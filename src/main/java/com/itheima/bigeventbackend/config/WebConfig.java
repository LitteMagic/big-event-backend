package com.itheima.bigeventbackend.config;

import com.itheima.bigeventbackend.constant.UrlConstants;
import com.itheima.bigeventbackend.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        添加登录拦截器
        registry.addInterceptor(loginInterceptor).excludePathPatterns(UrlConstants.EXCLUDE_FROM_LOGIN_INTERCEPTOR);
    }
}
