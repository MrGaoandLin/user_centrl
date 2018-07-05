package com.ut;

import com.ut.login.entity.User;

public class Test {

    public static void main(String[] agrs){

        User user = new User();
        user.setId(1L);
        user.setPassword("123456");
        user.setSex("man");
        user.setUserName("高磊");
        user.setState(false);
    }
}