package edu.miu.account_service.service;

import edu.miu.account_service.domain.Account;
import edu.miu.account_service.domain.Address;
import edu.miu.account_service.domain.Payment;
import edu.miu.account_service.repository.AccountRepository;
import edu.miu.account_service.repository.AddressRepository;
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
class AddressServiceTest {
    List<Address> addresses=new ArrayList<>();
    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressServiceImpl addressService;


    @BeforeEach
    public void setup() {
        Address add1=new Address(1L,"4th","fairfield","Iowa","52557");
        Address add2=new Address(2L,"2nd","Cedar Rapids","Iowa","52556");
        addresses.add(add1);
        addresses.add(add2);

    }

    @Test
    void saveAddress() {
        Address address=new Address(1L,"4th","fairfield","Iowa","52557");
        Mockito.when(addressRepository.save(address)).thenReturn(address);
        Address actual=addressService.saveAddress(address);
        assertThat(actual).isEqualTo(address);


    }

    @Test
    void getAllAdresses() {
        Mockito.when(addressRepository.findAll()).thenReturn(addresses);
        List<Address> actual=addressService.getAllAdresses();
        assertThat(actual).isEqualTo(addresses);


    }
}