package com.cxtx;

import com.cxtx.util.ContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class CxtxApplication {

    public static void main(String[] args) {
        // SpringBoot启动
        ConfigurableApplicationContext applicationContext = SpringApplication.run(CxtxApplication.class, args);
        ContextUtil.setApplicationContext(applicationContext);
    }

}
