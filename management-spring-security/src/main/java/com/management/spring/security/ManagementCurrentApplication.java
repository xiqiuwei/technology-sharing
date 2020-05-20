package com.management.spring.security;

import com.management.spring.security.springdesign.springdefined.MyApplicationContext;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

/**
 * @Author xiqiuwei
 * @Date Created in 23:07 2019/9/10
 * @Description
 * @Modified By:
 */
@SpringBootApplication
public class ManagementCurrentApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ManagementCurrentApplication.class);
        springApplication.setApplicationContextClass(MyApplicationContext.class);
        springApplication.run(args);
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new FileSystemResource("D:\\config\\application-uat.yml"));
        propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
        return propertySourcesPlaceholderConfigurer;
    }


}
