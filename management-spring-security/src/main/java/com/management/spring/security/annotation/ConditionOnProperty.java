package com.management.spring.security.annotation;

import com.management.spring.security.condition.MyCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @Author xiqiuwei
 * @Date Created in 20:57 2020/5/8
 * @Description
 * @Modified By:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Conditional(MyCondition.class)
public @interface ConditionOnProperty {
    String name() default "xiqiuwei";
    String value() default "santuer";
}
