package com.management.spring.security.springdesign.springdefined;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;

/**
 * @Author xiqiuwei
 * @Date Created in 23:10 2020/5/20
 * @Description 添加自定义环境变量到spring中
 * @Modified By:
 */
public class MyApplicationContext extends AnnotationConfigServletWebServerApplicationContext {
    @Override
    protected void initPropertySources() {
        super.initPropertySources();
        getEnvironment().setRequiredProperties("MY_PROPERTIES");
    }
}
