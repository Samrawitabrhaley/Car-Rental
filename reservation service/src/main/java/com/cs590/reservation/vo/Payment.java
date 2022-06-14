package com.cs590.reservation.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private String fullName;
    private String cardNumber;
    private String ccv;
    private LocalDate expirationDate;
    private Address address;
    private double totalPrice;

}
