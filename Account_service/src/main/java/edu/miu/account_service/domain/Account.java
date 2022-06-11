package edu.miu.account_service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String firstname;

    private String lastname;

    private Integer age;

    private String email;

    private String phoneNumber;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
	private Address address;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
	private Payment preferredPaymentMethod;

//    public boolean isPa(){
//        preferredPaymentMethod;
//        return false;
//    }


}
