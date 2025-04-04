package com.example.formula.controller;

import com.example.formula.entity.User;
import com.example.formula.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/public/create-user")
    public String hello() {
        User user = new User();
        user.setName("bob");
        User temp = userRepository.save(user);
        return "User saved successfully";
    }
}