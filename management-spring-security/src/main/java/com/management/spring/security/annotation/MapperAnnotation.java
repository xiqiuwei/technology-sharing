package com.management.spring.security.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * @Author xiqiuwei
 * @Date Created in 22:26 2020/5/8
 * @Description
 * @Modified By:
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Repository
public @interface MapperAnnotation {
    String value() default "";
}
