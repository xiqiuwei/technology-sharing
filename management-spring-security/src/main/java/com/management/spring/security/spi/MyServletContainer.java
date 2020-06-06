package com.management.spring.security.spi;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

/**
 * @Author xiqiuwei
 * @Date Created in 20:53 2020/5/22
 * @Description
 * @Modified By:
 */
public class MyServletContainer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {

    }
}
