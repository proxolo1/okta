package com.example.okta.controller;

import com.example.okta.model.PayLoad;
import com.example.okta.model.User;
import com.example.okta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private UserService userService;
    @PostMapping
    public User addUser(@RequestBody User payload) {
    return userService.saveUser(payload);
    }
}
