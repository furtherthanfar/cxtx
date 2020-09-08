package com.cxtx.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 先不加进去
public class InterceptorConfiguration implements WebMvcConfigurer {
    /*
    private static final String[] EXCLUDE_URI = {"/login","/signUp","/toSignUp"};

    @Autowired
    private UserInterceptor userInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor).addPathPatterns("/**").
                excludePathPatterns("/sign/*");
    }


     */
}
