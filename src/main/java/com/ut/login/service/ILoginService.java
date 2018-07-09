package com.ut.login.service;

import com.ut.login.entity.User;

import javax.servlet.http.HttpServletResponse;

public interface ILoginService {
    public String login(User user, HttpServletResponse response);
}
