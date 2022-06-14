package com.cs590.reservation.service;

import com.cs590.reservation.domain.Reservation;
import com.cs590.reservation.repository.ReservationRepository;
import com.cs590.reservation.vo.Inventory;
import com.cs590.reservation.vo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final WebClient.Builder webClientBuilder;
    private final Environment environment;
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, WebClient.Builder webClientBuilder, Environment environment, KafkaTemplate<String, String> kafkaTemplate) {
        this.reservationRepository = reservationRepository;
        this.webClientBuilder = webClientBuilder;
        this.environment = environment;
        this.kafkaTemplate = kafkaTemplate;
    }


    @Override
    public List<Reservation> getAllReservations() {
        kafkaTemplate.send("Notifications", "what is this???");
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(String id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public List<Reservation> getReservationsBiRenterId(String renterId) {
        return reservationRepository.findAllByRenterId(renterId);
    }

    @Override
    public List<Reservation> getReservationsByFullName(String fullName) {
        return reservationRepository.findAllByFullName(fullName);
    }

    @Override
    public Reservation createReservation(Reservation reservation) {

        Double dayPrice = webClientBuilder.build().get()
                .uri("http://CAR/api/cars/" + reservation.getCarId() + "/active")
                .headers(h -> h.set("Car-sevice-auth", environment.getProperty("CAR-SERVICE-AUTH")))
                .retrieve()
                .bodyToMono(Double.class)
                .block();
//        Boolean isActive = false;

        if (reservation.getStartDate().isAfter(LocalDate.now()) && reservation.getEndDate().isAfter(reservation.getStartDate())){
            if (dayPrice != null) {
                Inventory bookingInventory = new Inventory(reservation.getCarId(), reservation.getStartDate(), reservation.getEndDate());
                Boolean isAvailable = webClientBuilder.build().post()
                        .uri("http://INVENTORY/api/inventory/available")
                        .headers(h -> h.set("Inventory-service-auth", environment.getProperty("INVENTORY-SERVICE-AUTH")))
                        .bodyValue(bookingInventory)
                        .retrieve()
                        .bodyToMono(Boolean.class)
                        .block();

                if (!isAvailable) {
                    long numberOfDays = Duration.between(reservation.getStartDate().atStartOfDay(), reservation.getEndDate().atStartOfDay()).toDays();
                    double totalPrice = numberOfDays * dayPrice;
                    reservation.setTotalPrice(totalPrice);
                    Payment payment = reservation.getPayment();
                    payment.setTotalPrice(totalPrice);
                    Boolean isPaid = webClientBuilder.build().post()
                            .uri("http://PAYMENT/api/payments/" + "userId")
                            .headers(h -> h.set("Payment-service-auth", environment.getProperty("PAYMENT-SERVICE-AUTH")))
                            .bodyValue(payment)
                            .retrieve()
                            .bodyToMono(Boolean.class)
                            .block();

                    if (isPaid) {
                        Boolean isBooked = webClientBuilder.build().post()
                                .uri("http://INVENTORY/api/inventory/")
                                .headers(h -> h.set("Inventory-service-auth", environment.getProperty("INVENTORY-SERVICE-AUTH")))
                                .bodyValue(bookingInventory)
                                .retrieve()
                                .bodyToMono(Boolean.class)
                                .block();

                        if (isBooked){
                            Reservation finalReservation = reservationRepository.save(reservation);
                            kafkaTemplate.send("Notifications", finalReservation.toString());
                            return finalReservation;
                        }
                        else {
                            throw new IllegalArgumentException("Booking failed. Please try again later!");
                        }
                    }
                    else {
                        throw new IllegalArgumentException("Payment denied. Please try again later!");
                    }
                }
                else {
                    throw new IllegalArgumentException("Booking dates are not available. Please try different times!");
                }
            }
            else {
                throw new IllegalArgumentException("Car is currently not available. Please try different car!");
            }
        }
        else {
            throw new IllegalArgumentException("Dates are in the past. Please check booking dates!");
        }


    }
}
