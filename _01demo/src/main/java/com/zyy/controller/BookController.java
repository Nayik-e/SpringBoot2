package com.zyy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Value("${password}")
    private String password;

    @GetMapping
    public String getBook(){
        System.out.println("Spring Boot is running..");
        System.out.println("password->"+password);
        return "springBoot is running..";
    }
}
