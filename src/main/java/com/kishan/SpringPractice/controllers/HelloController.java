package com.kishan.SpringPractice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* Sample Hello controller for testing Spring Application
* */

@RestController
@RequestMapping("/home")
public class HelloController {

    @Value("${db.username}")
    private String username;

    @RequestMapping("/")
    public String getHello() {
        return "Welcome to Spring " + username;
    }
}
