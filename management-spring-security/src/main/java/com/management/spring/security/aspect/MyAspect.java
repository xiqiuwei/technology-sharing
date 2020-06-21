package com.management.spring.security.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * @Author xiqiuwei
 * @Date Created in 22:20 2019/10/28
 * @Description 获取方法参数的切面
 * @Modified By: xiqiuwei
 */

@Aspect
@Component
public class MyAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyAspect.class);

    private static final String[] types = {
            "java.lang.Integer", "java.lang.Double", "java.lang.Float",
            "java.lang.Long", "java.lang.Short", "java.lang.Byte",
            "java.lang.Boolean", "java.lang.Char", "java.lang.String",
            "int", "double", "long", "short", "byte", "boolean", "char", "float"};

    /**
     * 切面表达式
     */
    @Pointcut("execution(public * com.management.spring.security.controller.*.*(..))")
    public void pointCut() {
    }


    @Around("pointCut()")
    public String aroundAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if (null == args || 0 == args.length)
            return "参数不能为空！！！";
        String proceed = (String) joinPoint.proceed();
        for (Object arg : args) {
            for (String type : types) {
                // 如果是基本类型直接打印
                if (type.equals(arg.getClass().getTypeName())) LOGGER.info(arg + ";");
                    // 对象类型反射获取私有字段打印
                else LOGGER.info(getFieldsValues(arg));
            }
        }
        return proceed;
    }


    private String getFieldsValues(Object obj) {
        //通过反射获取所有的字段，getFields()获取public的修饰的字段
        //getDeclaredFields获取private protected public修饰的字段
        Field[] fields = obj.getClass().getDeclaredFields();
        String typeName = obj.getClass().getTypeName();
        for (String t : types) {
            if (t.equals(typeName)) {
                return (String) obj;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Field f : fields) {
            //在反射时能访问私有变量
            f.setAccessible(true);
            try {
                for (String str : types) {
                    //这边会有问题，如果实体类里面继续包含实体类，这边就没法获取。
                    //其实，我们可以通递归的方式去处理实体类包含实体类的问题。
                    if (f.getType().getName().equals(str)) {
                        sb.append(f.getName()).append(" : ").append(f.get(obj)).append(", ");
                    }
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
