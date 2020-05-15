package com.management.spring.security.annotation;

import com.management.spring.security.importselector.MyImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author xiqiuwei
 * @Date Created in 22:32 2020/5/8
 * @Description
 * @Modified By:
 */

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
//@Import(MyTest.class)
@Import(MyImportSelector.class)
public @interface MyEnableApplication {
    String value() default "";
}
