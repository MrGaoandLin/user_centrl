package com.ut.login.service;

import com.ut.login.entity.User;

import java.util.List;

public interface IUserService {

    public User findById(Long id);

    public List<User> findAll();

    public void add(User user);
}
