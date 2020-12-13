package com.greenism.springsecurity.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @PostMapping("/admin/hello")
    public String admin() {
        return "hello admin";
    }

    @PostMapping("/user/hello")
    public String user() {
        return "hello user";
    }

    @PostMapping("/hello")
    public String hello() {
        return "hello";
    }
}