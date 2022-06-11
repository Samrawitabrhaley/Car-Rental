package com.ccpayment.ccpaayment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
public class Payment {
    private String fullName;
    private String cardNumber;
    private String ccv;
    private LocalDate expirationDate;
    private Address address;
    private double totalPrice;
    //private LocalDate expirationDate;
}