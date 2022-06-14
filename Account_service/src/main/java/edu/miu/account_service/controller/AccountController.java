package edu.miu.account_service.controller;

import edu.miu.account_service.config.WebConfigClient;
import edu.miu.account_service.domain.Account;
import edu.miu.account_service.security.JwtUtils;
import edu.miu.account_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private WebClient.Builder webClientBuilder;
    @Autowired
    private Environment environment;



    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account, @RequestHeader(value = "Authorization", required = false) String headerAuth) {
        String token = parseJwt(headerAuth);
        if (token != null && jwtUtils.validateJwtToken(token)){
            String userId = jwtUtils.getUserIdFromJwtToken(token);

            webClientBuilder.build().put()
                    .uri("http://USER/api/users/" + userId)
                    .headers(h -> h.set("User-service-auth", environment.getProperty("USER-SERVICE-AUTH")))
                    .bodyValue(account.getId())
                    .retrieve()
                    .bodyToMono(void.class)
                    .block();

            return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(account));
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable String id) {
        return accountService.getAccount(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(String id) {
        accountService.deleteAccount(id);





    }
    private String parseJwt(String headerAuth) {
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }
        return null;
    }







}
