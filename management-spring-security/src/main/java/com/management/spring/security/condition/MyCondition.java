package com.management.spring.security.condition;

import com.management.spring.security.annotation.ConditionOnProperty;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

/**
 * @Author xiqiuwei
 * @Date Created in 20:56 2020/5/8
 * @Description
 * @Modified By:
 */
public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
        MultiValueMap<String, Object> attributes = metadata.getAllAnnotationAttributes(ConditionOnProperty.class.getName());
        String name = String.valueOf(attributes.get("name"));
        String value = String.valueOf(attributes.get("value"));
        String propertyName = System.getProperty(name);
        return propertyName.equals(value);
    }
}
