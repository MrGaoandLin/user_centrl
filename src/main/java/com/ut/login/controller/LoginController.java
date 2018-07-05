package com.ut.login.controller;


import com.sun.deploy.net.HttpResponse;
import com.ut.login.entity.User;
import com.ut.login.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;

@RestController
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("login")
    public HttpResponse login(User user, HttpResponse response){

        return response;
    }
}
