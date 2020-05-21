package com.management.spring.security.springdesign.springdefined;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.lang.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.*;

/**
 * @Author xiqiuwei
 * @Date Created in 21:52 2020/5/21
 * @Description
 * @Modified By:
 */
@Configuration
public class YmlConfigurationFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, @Nullable EncodedResource resource) throws IOException {
        String resourceName = Optional.ofNullable(name).orElse(resource.getResource().getFilename());
        if (resourceName.endsWith(".yml") || resourceName.endsWith(".yaml")) {
            List<PropertySource<?>> yamlSources = new YamlPropertySourceLoader().load(resourceName, resource.getResource());
            System.err.println("读取当前环境下面的文件: "+resourceName);
            return yamlSources.get(0);
        } else {
            return new DefaultPropertySourceFactory().createPropertySource(name, resource);
        }
    }
}
