package com.easybytes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world With Spring Security..";
    }
}
