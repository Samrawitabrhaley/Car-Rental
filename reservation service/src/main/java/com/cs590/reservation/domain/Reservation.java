package com.cs590.reservation.domain;

import com.cs590.reservation.vo.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "reservation")
public class Reservation {

    @Id
    private String id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String carId;
    private Long renterId;
    private Double totalPrice;
    private Payment payment;
}
