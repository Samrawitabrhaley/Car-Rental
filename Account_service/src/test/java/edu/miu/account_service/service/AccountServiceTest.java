package edu.miu.account_service.service;

import edu.miu.account_service.domain.Account;
import edu.miu.account_service.domain.Address;
import edu.miu.account_service.domain.Payment;
import edu.miu.account_service.repository.AccountRepository;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
        List<Account> accounts=new ArrayList<>();
        @Mock
        private AccountRepository accountRepository;

        @InjectMocks
        private AccountServiceImpl accountService;


        @BeforeEach
        public void setup() {
            Address add1=new Address(1L,"4th","fairfield","Iowa","52557");
            Address add2=new Address(2L,"2nd","Cedar Rapids","Iowa","52556");

            Payment creditCard1=new Payment(1l,"Joe","43323","345","11/2026",add1);
            Payment creditCard2=new Payment(2l,"Jordan","23365","987","10/2026",add1);

            Account account1=new Account("1","Joe","Williams",25,"joewill@gmail.com","12345",add1,creditCard1);
            Account account2=new Account("1","Jordan","Williams",29,"jordanwill@gmail.com","45123",add1,creditCard2);

            accounts.add(account1);
            accounts.add(account2);
        }

    @Test
    void createAccount() {
        Address add3=new Address(3L,"4th","fairfield","Iowa","52557");
        Payment creditCard3=new Payment(3L,"bruce","43323","325","11/2026",add3);
        Account account3=new Account("1","bruce","Williams",24,"brucewill@gmail.com","145125",add3,creditCard3);

        Mockito.when(accountRepository.save(account3)).thenReturn(account3);
        Account actual=accountService.createAccount(account3);
        assertThat(actual).isEqualTo(account3);


    }


    @Test
    void deleteAccount() {
        accountService.deleteAccount("1");
        verify(accountRepository, times(1)).deleteById("1");

    }
}