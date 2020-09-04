package com.cxtx;

import com.cxtx.context.ContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class CxtxApplication {

    public static void main(String[] args) {
        // SpringBoot启动
        ConfigurableApplicationContext applicationContext = SpringApplication.run(CxtxApplication.class, args);
        // 容器工具类设置
        ContextUtil.setApplicationContext(applicationContext);

    }

}
