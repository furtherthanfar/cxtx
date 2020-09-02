package com.cxtx.context;

import org.springframework.context.ApplicationContext;

public class ContextUtil {
    // 容器
    private static ApplicationContext applicationContext;

    public static synchronized boolean setApplicationContext(ApplicationContext context){
        if(applicationContext == null){
            ContextUtil.applicationContext = context;
            System.out.println("Yes");
            return true;
        }

        System.out.println("ApplicationContext Has Been Set, Can't Repeatable Set!");
        return false;
    }

    /**
     * 根据bean名称获取bean
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }

    /**
     * 根据bean名称和Class获取bean
     * @param beanName
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(String beanName, Class<T> clazz){
        return applicationContext.getBean(beanName, clazz);
    }

    /**
     * 根据Class获取bean
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }



}
