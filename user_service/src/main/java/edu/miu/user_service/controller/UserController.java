package edu.miu.user_service.controller;

import edu.miu.user_service.domain.User;
import edu.miu.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
//    RestTemplate restTemplate=new RestTemplate();

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getAllUsers(@RequestHeader(value = "Authorization", required = false) String headerAuth){
//      System.out.println("THIS IS FROM THE HEADER REQUEST: " + headerAuth);
        return userService.findAll();
    }

//    @GetMapping("/{id}/account")
//    public Account getAccountByUserId(@PathVariable("id") Long id){
//        return userService.getAccountByUserId(id);
//    }


}
