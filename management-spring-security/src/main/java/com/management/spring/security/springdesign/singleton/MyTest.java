package com.management.spring.security.springdesign.singleton;

/**
 * @Author xiqiuwei
 * @Date Created in 20:36 2020/5/2
 * @Description
 * @Modified By:
 */
public class MyTest {
    public static void main(String[] args) {
        Composition instance = Composition.getInstance();
        System.out.println("主线程对象1："+instance);
        new Thread(new Runnable() {
            @Override
            public void run() {
                instance.function("奚秋伟");
                System.err.println("1子线程对象1："+instance);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                instance.function("三土");
                System.err.println("2子线程对象1："+instance);
            }
        }).start();
    }
}
