package com.example.formula.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @GetMapping("/public/health")
    public String ok(){
        return "ok";
    }

    @GetMapping("/secure/hello")
    public String secureHello() {
        return "✅ JWT is valid! You have accessed a protected endpoint.";
    }
}
