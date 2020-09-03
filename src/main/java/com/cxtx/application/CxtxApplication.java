package com.cxtx.application;

import com.cxtx.context.ContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.UnsupportedEncodingException;


@SpringBootApplication
public class CxtxApplication {

    public static void main(String[] args) {
        // SpringBoot启动
        ConfigurableApplicationContext applicationContext = SpringApplication.run(CxtxApplication.class, args);
        // 容器工具类设置
        ContextUtil.setApplicationContext(applicationContext);

    }

}
