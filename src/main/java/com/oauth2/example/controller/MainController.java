package com.oauth2.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oauth2.example.domain.UserInfo;

import java.security.Principal;

@RestController
@RequestMapping("/oauth2")
public class MainController {

    @GetMapping("/hello")
    public String sayHello(Principal principal) {
        return "Hello, " + principal.getName();
    }
    
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping("/hi")
    public String sayHi() {
        return "Hi~";
    }

    @RequestMapping("/user-info")
    public UserInfo userInfo(Principal principal) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(principal.getName());
        return userInfo;
    }
}