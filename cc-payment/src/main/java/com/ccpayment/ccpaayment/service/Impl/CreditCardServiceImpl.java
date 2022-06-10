package com.ccpayment.ccpaayment.service.Impl;

import com.ccpayment.ccpaayment.model.CreditCard;
import com.ccpayment.ccpaayment.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    @Override
    public CreditCard saveCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    public List<CreditCard> getCards() {
        return creditCardRepository.findAll();
    }

    @Override
    public CreditCard getCardById(Long id) {
        return creditCardRepository.getById(id);
    }

    @Override
    public void deleteCard(Long id) {
        creditCardRepository.deleteById(id);

    }
}
