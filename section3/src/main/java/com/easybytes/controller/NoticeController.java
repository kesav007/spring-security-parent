package com.easybytes.controller;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

    WebSecurityConfiguration wes;

    @GetMapping("/notices")
    public String getNotices() {
        return "Here are the notices details from the DB";
    }
}
