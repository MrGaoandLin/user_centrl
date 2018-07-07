package com.ut.login.controller;


import com.ut.annotation.ServiceComponent;
import com.ut.login.entity.User;
import com.ut.login.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("login")
    @ServiceComponent(session = false)
    public String login(User user, HttpServletResponse response){
        loginService.login(user,response);
        return "sucess";
    }
}
