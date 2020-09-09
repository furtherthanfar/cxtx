package com.cxtx.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@Configuration
public class LockConfiguration {

    @Bean
    public ReentrantLock reentrantLock(){
        return new ReentrantLock();
    }

    @Bean(name = "headImageInteger")
    public AtomicInteger atomicInteger(){
        return new AtomicInteger(0);
    }



}
