package com.example.okta.service;

import com.example.okta.model.User;
import com.example.okta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository mongoRepo;
    public User saveUser(User user) {
        user.setId(UUID.randomUUID().toString().split("-")[0]);
      return mongoRepo.save(user);
    }
}
