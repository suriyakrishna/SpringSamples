package com.kishan.springpractice.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/")
    @ApiOperation(value = "Greets the user", notes = "Greet Spring User with their name", response = String.class)
    public String getHello() {
        return "Welcome to Spring " + username;
    }
}
