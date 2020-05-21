package com.management.spring.security;

import com.management.spring.security.springdesign.springdefined.YmlConfigurationFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author xiqiuwei
 * @Date Created in 23:07 2019/9/10
 * @Description
 * @Modified By:
 */
@SpringBootApplication
@PropertySource(factory = YmlConfigurationFactory.class,ignoreResourceNotFound = true,value = "classpath:application-${ENV_NAME}.yml",encoding = "UTF-8")
public class ManagementCurrentApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ManagementCurrentApplication.class);
        springApplication.run(args);
    }
}
