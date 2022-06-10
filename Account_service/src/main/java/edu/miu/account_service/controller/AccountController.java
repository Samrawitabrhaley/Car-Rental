package edu.miu.account_service.controller;

import edu.miu.account_service.domain.Account;
import edu.miu.account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(Long id) {
        accountService.deleteAccount(id);

    }







}
