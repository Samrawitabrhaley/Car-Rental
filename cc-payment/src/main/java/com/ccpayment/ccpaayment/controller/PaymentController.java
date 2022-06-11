package com.ccpayment.ccpaayment.controller;

import com.ccpayment.ccpaayment.dto.Payment;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class PaymentController {

    private Environment environment;

    @PostMapping("")
    public ResponseEntity<Boolean> getAllReservations(@RequestBody Payment payment,
                                                      @RequestHeader(value = "Authorization", required = false) String headerAuth) {

        String secret = environment.getProperty("PAYMENT-SERVICE-AUTH");
        if (headerAuth.equals(secret) && payment.getCardNumber() != null
                && payment.getCcv() != null && payment.getExpirationDate().isAfter(LocalDate.now())) {
                return ResponseEntity.status(HttpStatus.OK).body(true);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
            }
        }
    }

