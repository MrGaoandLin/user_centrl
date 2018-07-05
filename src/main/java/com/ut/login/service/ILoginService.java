package com.ut.login.service;

import com.sun.deploy.net.HttpResponse;
import com.ut.login.entity.User;

public interface ILoginService {

    public String login(User user, HttpResponse response);
}
