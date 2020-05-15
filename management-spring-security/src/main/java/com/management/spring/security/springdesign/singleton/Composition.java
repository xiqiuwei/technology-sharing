package com.management.spring.security.springdesign.singleton;

/**
 * @Author xiqiuwei
 * @Date Created in 13:19 2019/10/26
 * @Description
 * @Modified By:
 */

public class Composition {
    private String name;
    private String age;
    private static Composition composition;

    public Composition() {
    }

    public static Composition getInstance() {
        if (null == composition) {
            synchronized (Composition.class) {
                if (null == composition) {
                    composition = new Composition();
                }
            }
        }
        return composition;
    }

    public void function(String name) {
        System.out.println("your name is ：" + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
