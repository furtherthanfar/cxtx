package com.cxtx;

import com.cxtx.util.ContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author lqk
 * @Date 2020/9/17
 * @Description
 */
@SpringBootApplication
public class CxtxApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(CxtxApplication.class, args);
        ContextUtil.setApplicationContext(applicationContext);

    }
}
