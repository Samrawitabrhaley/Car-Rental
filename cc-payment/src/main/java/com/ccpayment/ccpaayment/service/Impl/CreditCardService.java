package com.ccpayment.ccpaayment.service.Impl;

import com.ccpayment.ccpaayment.model.CreditCard;


import java.util.List;

public interface CreditCardService {
    public CreditCard saveCard(CreditCard creditCard);
    public List<CreditCard> getCards();
    public CreditCard getCardById(Long id);
    public void deleteCard(Long id);



}
