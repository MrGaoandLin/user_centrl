package com.ut.login.service.impl;

import com.ut.commonUtil.exceptionUtil.CommonUtil;
import com.ut.commonUtil.exceptionUtil.ExceptionUtil;
import com.ut.login.dao.UserDAO;
import com.ut.login.entity.MapCache;
import com.ut.login.entity.User;
import com.ut.login.service.ILoginService;
import com.ut.webconfig.interceptor.WebInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private UserDAO userDAO;

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Override
    public String login(User user, HttpServletResponse response) {

        if (user == null ){
            ExceptionUtil.validationException("登录名密码不能为空");
        }
        System.out.println(user);
        User myUser = userDAO.findById(user.getId());

//        listUser = new ArrayList<>();
        if (user.getUserName().equals(myUser.getUserName()) && user.getPassword().equals(myUser.getPassword())){

            //创建List保存sessionId和user的关系，方便下次验证
            Map<String,Object> userMap = new HashMap<String, Object>();
            String cookieId = CommonUtil.getUUID();
            userMap.put("user",user);
            userMap.put("cookieId",cookieId);
            Cookie cookie = new Cookie("cookieId",cookieId);
            cookie.setPath("/");
            cookie.setMaxAge(WebInterceptor.COOKIE_TIMEOUT);
            response.addCookie(cookie);
            MapCache.setCacheMap("cookieId",userMap);
        }
        logger.debug("This is test message logback");
        logger.info("This is test message logback");
        logger.error("This is test message logback");
        return null;
    }
}
