package com.management.spring.security.threaddemo.customthread;

import javafx.concurrent.Task;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * @Author xiqiuwei
 * @Date Created in 20:01 2020/6/6
 * @Description
 * @Modified By:
 */

@SuppressWarnings("unused")
public class MyThreadPool {
    private ThreadPoolExecutor userDefinedPool = new ThreadPoolExecutor(
            5, // 核心线程数，当线程池处于空闲也不会销毁，
            // 当前运行的线程少于corePoolSize的时候会创建新的线程来执行任务，但是执行这一步的时候会获取全局锁
            10, // 线程池最大线程数，其实就是当核心线程数与工作队列都满了后就会创建maximumPoolSize新线程，
            // 当这里的线程也满了后就会调用拒绝策略
            10, // 线程池空闲时间maximumPoolSize线程的存活时间
            TimeUnit.SECONDS, // keepAliveTime的时间单位
            new ArrayBlockingQueue<Runnable>(20), // 有界队列，当运行线程 > corePoolSize后会把其余的运行线程缓存到工作队列当中，
            // 当这个有界队列满了后就会调用maximumPoolSize创建新线程
            new MyThreadFactory(), // 自定义线程的prefix
            new MyRejected()); // 自定义拒绝策略
    // 执行runnable无返回值
    public void execute(Runnable runnable){
        userDefinedPool.execute(runnable);
    }
    // 执行callable自定义返回值类型
    public Future<?> submit(Callable<?> callable) {
        return userDefinedPool.submit(callable);
    }

    public void shutdown(){
        userDefinedPool.shutdown();
    }


}
