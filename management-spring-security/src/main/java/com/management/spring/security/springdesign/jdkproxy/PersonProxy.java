package com.management.spring.security.springdesign.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 代理类
 * @Author xiqiuwei
 * @Date Created in 20:23 2020/5/10
 * @Description
 * @Modified By:
 */
public class PersonProxy implements InvocationHandler {
   private Person object;

    public Object getInstance(Person person) {
        this.object = person;
        Class clazz = person.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this::invoke);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始代理");
        if ("getAge".equals(method.getName())) {
            System.out.println(method.getName());
            Integer age = (Integer)method.invoke(object, args);
            if (age > 28) {
                System.err.println("大于28岁的对象不考虑\n");
            }
        }
        if ("blindDate".equals(method.getName())) {
            System.out.println(method.getName());
            method.invoke(object,args);
        }
        System.out.println("代理结束");
        return null;
    }
}
