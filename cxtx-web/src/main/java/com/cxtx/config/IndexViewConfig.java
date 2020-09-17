package com.cxtx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lqk
 * @Date 2020/9/17
 * @Description
 */
@Configuration
public class IndexViewConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/signUp.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}