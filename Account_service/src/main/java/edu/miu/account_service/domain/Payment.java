package edu.miu.account_service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String cardNumber;
    private String ccv;
    private String expiryDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_address_id")
    private Address address;


}

