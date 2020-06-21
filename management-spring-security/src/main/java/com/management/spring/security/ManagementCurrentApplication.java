package com.management.spring.security;

import com.management.spring.security.security.filter.VerifyFilter;
import com.management.spring.security.security.servlet.VerifyServlet;
import com.management.spring.security.springdesign.springdefined.YmlConfigurationFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author xiqiuwei
 * @Date Created in 23:07 2019/9/10
 * @Description
 * @Modified By: xiqiuwei
 */
@SpringBootApplication
@PropertySource(factory = YmlConfigurationFactory.class,ignoreResourceNotFound = true,value = "classpath:application-${ENV_NAME}.yml",encoding = "UTF-8")
public class ManagementCurrentApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ManagementCurrentApplication.class);
        springApplication.run(args);
    }

    /**
     * 注入验证码servlet
     */
    @Bean
    public ServletRegistrationBean indexServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new VerifyServlet());
        registration.addUrlMappings("/getVerifyCode");
        return registration;
    }

    @Bean
    public FilterRegistrationBean<VerifyFilter> filterRegistrationBean(){
        return new FilterRegistrationBean<>(new VerifyFilter());
    }
}
