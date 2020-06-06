package com.management.spring.security.threaddemo.customthread;

import org.springframework.stereotype.Component;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author xiqiuwei
 * @Date Created in 20:35 2020/6/6
 * @Description
 * @Modified By:
 */

public class MyRejected implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.err.println(r.toString()); // 控制台输出当前拒绝的线程
    }
}
