package com.ut.webconfig.interceptor;

import com.ut.annotation.ServiceComponent;
import com.ut.login.entity.MapCache;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:自定义拦截器
 * User: gaolei
 * Date: 2018/7/9
 * Time: 上午 09:35
 */
@Component
public class WebInterceptor extends HandlerInterceptorAdapter {

    public static final int COOKIE_TIMEOUT = 60 * 1;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("在请求之前做一些事情！");
        //如果这个请求不是
        if (!(handler instanceof HandlerMethod) || ((HandlerMethod)handler).getBean() instanceof org.springframework.boot.autoconfigure.web.ErrorController)
            return true;

        //解决跨域请求问题
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if ((!handlerMethod.hasMethodAnnotation(ServiceComponent.class)) || handlerMethod.getMethodAnnotation(ServiceComponent.class).session()) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("cookieId".equals(cookie.getName())) {
                        String cookieId = cookie.getValue();
                        cookie.setPath("/");
                        cookie.setMaxAge(COOKIE_TIMEOUT);
                        response.addCookie(cookie);
                        Map<String,Object> userMap = MapCache.getCacheMap();
                        userMap.get(cookieId);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("在处理之后做一些事情");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("在结束之后做一些事情");
    }
}
