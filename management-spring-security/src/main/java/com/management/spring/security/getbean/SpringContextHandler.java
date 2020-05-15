package com.management.spring.security.getbean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @Author xiqiuwei
 * @Date Created in 23:12 2020/5/7
 * @Description
 * @Modified By:
 */
@Component
public class SpringContextHandler implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 传递上下文参数初始化成员变量applicationContext
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(@Nullable ApplicationContext applicationContext) throws BeansException {
        SpringContextHandler.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return SpringContextHandler.applicationContext;
    }
    /**
     * 根据类型获取bean
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T>T getBeanByType(Class<T> clazz){
        isNull();
        return SpringContextHandler.applicationContext.getBean(clazz);
    }
    /**
     * 根据类名获取bean
     * @param name
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T>T getBeanByName(String name) {
        isNull();
        return (T)SpringContextHandler.applicationContext.getBean(name);
    }

    private static void isNull() {
        if (applicationContext == null) {
           throw new IllegalArgumentException("applicationContext不能为空");
        }
    }
}
