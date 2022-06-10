package com.cs590.reservation.service;

import com.cs590.reservation.domain.Reservation;

import java.util.List;

public interface ReservationService {

    public List<Reservation> getAllReservations();
    public Reservation getReservationById(String id);
    public Reservation createReservation(Reservation reservation);

}
