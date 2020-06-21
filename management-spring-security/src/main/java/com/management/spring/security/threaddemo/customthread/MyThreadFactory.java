package com.management.spring.security.threaddemo.customthread;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author xiqiuwei
 * @Date Created in 21:15 2020/6/6
 * @Description
 * @Modified By:
 */

public class MyThreadFactory implements ThreadFactory {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public Thread newThread(@Nullable Runnable r) {
        int index = atomicInteger.incrementAndGet();
        Thread thread = new Thread(r, "My-Thread-" + index);
        System.out.println("当前执行的线程:" + thread.getName());
        return thread;
    }
}
