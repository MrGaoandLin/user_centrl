package com.ut.login.controller;

import com.ut.login.entity.User;
import com.ut.login.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PutMapping("add")
    public void add(User user){

        userService.add(user);
    }

    @GetMapping("findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("findById")
    public User findById(Long id){
        return userService.findById(id);
    }
}
