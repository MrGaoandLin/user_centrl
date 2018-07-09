package com.ut;

import com.ut.login.entity.User;
import com.ut.login.service.impl.LoginServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] agrs){

        User user = new User();
        user.setId(1L);
        user.setPassword("123456");
        user.setSex("man");
        user.setUserName("高磊");
        user.setState(false);

        logger.debug("This is degub message {}",user);
        logger.error("This is degub error");
        logger.info("This is degub info");
    }
}