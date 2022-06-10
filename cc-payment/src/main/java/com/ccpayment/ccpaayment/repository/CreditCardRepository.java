package com.ccpayment.ccpaayment.repository;

import com.ccpayment.ccpaayment.model.CreditCard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
}
