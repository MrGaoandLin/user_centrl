package com.ut.webconfig.interceptor;

import com.ut.commonUtil.exceptionUtil.CommonUtil;
import org.apache.catalina.SessionIdGenerator;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WebInterceptor extends HandlerInterceptorAdapter {

    public static final int COOKIE_TIMEOUT = 60 * 1;


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //请求之前做一些东西

//        if (!(handler instanceof HandlerMethod) || ((HandlerMethod)handler).getBean() instanceof org.springframework.boot.autoconfigure.web.ErrorController)
//            return true;
//
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
        HttpSession session = request.getSession();
        String sessionId = (String)session.getAttribute("sessionId");
        if (sessionId == null || "".equals(sessionId)){
            Cookie cookie = new Cookie("sessionId",CommonUtil.getUUID());
            cookie.setPath("/");
            cookie.setMaxAge(-1);
            response.addCookie(cookie);
        }else {
            Cookie cookie = new Cookie("sessionId",sessionId );
            cookie.setPath("/");
            cookie.setMaxAge(COOKIE_TIMEOUT);
            response.addCookie(cookie);
        }


        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {


    }
}
