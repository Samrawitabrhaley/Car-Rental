package com.cs590.reservation.repository;

import com.cs590.reservation.domain.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends MongoRepository<Reservation, String> {

    public List<Reservation> findAllByRenterId(String renterId);
    public List<Reservation> findAllByFullName(String fullName);
}
