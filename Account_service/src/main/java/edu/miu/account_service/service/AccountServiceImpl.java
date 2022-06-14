package edu.miu.account_service.service;

import edu.miu.account_service.domain.Account;
import edu.miu.account_service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(String id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public void deleteAccount(String  id) {
        accountRepository.deleteById(id);

    }
}
