package com.ut.login.service.impl;

import com.sun.deploy.net.HttpResponse;
import com.ut.commonUtil.exceptionUtil.ExceptionUtil;
import com.ut.login.dao.UserDAO;
import com.ut.login.entity.User;
import com.ut.login.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private UserDAO userDAO;

    private List<User> listUser;

    @Override
    public String login(User user, HttpResponse response) {

        if (user == null ){
            ExceptionUtil.validationException("登录名密码不能为空");
        }
        User myUser = userDAO.findById(user.getId());

//        listUser = new ArrayList<>();
        if (user.getUserName().equals(myUser.getUserName()) && user.getPassword().equals(myUser.getPassword())){

            listUser.add(user);
//          ThreadLocal threadLocal = new ThreadLocal();
        }

        return null;
    }
}
