package edu.miu.account_service.service;

import edu.miu.account_service.domain.Address;
import edu.miu.account_service.domain.Payment;
import edu.miu.account_service.repository.AddressRepository;
import edu.miu.account_service.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

        @Mock
        private PaymentRepository paymentRepository;

        @InjectMocks
        private PaymentServiceImpl paymentService;


    @Test
    void savePayment() {
        Address address=new Address(2L,"2nd","Cedar Rapids","Iowa","52556");
        Payment creditCard=new Payment(1l,"Joe","43323","345","11/2026",address);
        Mockito.when(paymentRepository.save(creditCard)).thenReturn(creditCard);
        Payment actual=paymentService.savePayment(creditCard);
        assertThat(actual).isEqualTo(creditCard);

    }
}