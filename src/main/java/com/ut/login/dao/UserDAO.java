package com.ut.login.dao;

import com.ut.login.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User,Long> {

    public User findById(Long id);

    public List<User> findAll();
}
