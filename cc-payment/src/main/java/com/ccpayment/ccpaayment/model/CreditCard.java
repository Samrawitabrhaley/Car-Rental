package com.ccpayment.ccpaayment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreditCard {
    @Id
    @GeneratedValue
    private Long id;
    private Double  paymentTotal;


}
