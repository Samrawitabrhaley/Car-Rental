package edu.miu.user_service.service;

import edu.miu.user_service.domain.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User saveUser(User user);

    //public Account getAccountByUserId(Long id);

    boolean existsByUsername(String username);
}
