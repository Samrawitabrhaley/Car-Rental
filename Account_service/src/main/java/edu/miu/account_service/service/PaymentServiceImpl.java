package edu.miu.account_service.service;

import edu.miu.account_service.domain.Payment;
import edu.miu.account_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).get();
    }
}
