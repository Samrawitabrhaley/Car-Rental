package edu.miu.account_service.service;

import edu.miu.account_service.domain.Account;

public interface AccountService {
    public Account createAccount(Account account);
    public Account getAccount(String id);
    public void deleteAccount(String id);



}
