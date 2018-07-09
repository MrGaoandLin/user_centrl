package com.ut.webconfig.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * Description:用java描述拦截器配置
 * User: gaolei
 * Date: 2018/7/9
 * Time: 上午 09:35
 */
@SpringBootConfiguration
public class MyWebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private WebInterceptor webInterceptor;

    private static final String[] excluePathPatterns = {"/login/**","/swagger-resources/**","/swagger-ui.html/**","/v2/api-docs"};

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(webInterceptor).addPathPatterns("/**").excludePathPatterns(excluePathPatterns);
    }

}
