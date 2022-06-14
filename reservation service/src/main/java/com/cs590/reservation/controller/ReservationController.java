package com.cs590.reservation.controller;

import com.cs590.reservation.domain.Reservation;
import com.cs590.reservation.service.ReservationService;
import com.cs590.reservation.util.JwtUtils;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private ReservationService reservationService;
    private JwtUtils jwtUtils;


    public ReservationController(ReservationService reservationService, JwtUtils jwtUtils) {
        this.reservationService = reservationService;
        this.jwtUtils = jwtUtils;
    }

    @GetMapping("")
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable("id") String id){
        return reservationService.getReservationById(id);
    }

    @GetMapping("/renter")
    public ResponseEntity<List<Reservation>> getReservationsByRenterId(@RequestHeader(value = "Authorization", required = false) String headerAuth){

        String token = parseJwt(headerAuth);
        if (token != null && jwtUtils.validateJwtToken(token)){
            String renterId = jwtUtils.getUserIdFromJwtToken(token);
            return ResponseEntity.status(HttpStatus.OK).body(reservationService.getReservationsBiRenterId(renterId));
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/renter/{full-name}")
    public ResponseEntity<List<Reservation>> getReservationsByFullName(@PathVariable("full-name") String fullName,
                                                                       @RequestHeader(value = "Authorization", required = false) String headerAuth){
        String token = parseJwt(headerAuth);
        if (token != null && jwtUtils.validateJwtToken(token) && jwtUtils.getUserTypeFromJwtToken(token).equals("ADMIN")){
            return ResponseEntity.status(HttpStatus.OK).body(reservationService.getReservationsByFullName(fullName));
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("")
    public ResponseEntity<Reservation> bookReservation(@RequestBody Reservation reservation, @RequestHeader(value = "Authorization", required = false) String headerAuth){
        String token = parseJwt(headerAuth);
        if(token != null && jwtUtils.validateJwtToken(token)){
            String renterId = jwtUtils.getUserIdFromJwtToken(token);
            reservation.setRenterId(renterId);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.createReservation(reservation));
    }

    private String parseJwt(String headerAuth) {
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }
        return null;
    }
}
