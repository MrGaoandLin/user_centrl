package com.ut.login.service.impl;

import com.ut.login.dao.UserDAO;
import com.ut.login.entity.User;
import com.ut.login.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findById(Long id) {

        return userDAO.findById(id);
    }

    @Override
    public List<User> findAll() {

        return userDAO.findAll();
    }

    @Override
    public void add(User user) {

        userDAO.save(user);
    }
}
