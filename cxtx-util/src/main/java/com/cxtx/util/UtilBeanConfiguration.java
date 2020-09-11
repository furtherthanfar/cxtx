package com.cxtx.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@Configuration
public class UtilBeanConfiguration {
    /**
     * Lock 锁
     * @return
     */
    @Bean
    public ReentrantLock reentrantLock(){
        return new ReentrantLock();
    }

    /**
     * 获得用户头像计数器
     * @return
     */
    @Bean(name = "headImageInteger")
    @Scope(value = "prototype")
    public AtomicInteger atomicHeadImage(){
        return new AtomicInteger(0);
    }

    /**
     * 景点图片计数器
     * @return
     */
    @Bean(name = "sitePictureInteger")
    @Scope(scopeName = "prototype")
    public AtomicInteger amoticSitePic(){
        return new AtomicInteger(0);
    }

    /**
     * 日期格式化器
     * @return
     */
    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    }

    /**
     * 日期bean
     * @return
     */
    @Bean
    @Scope(value = "prototype")
    public Date date(){
        return new Date();
    }

}
