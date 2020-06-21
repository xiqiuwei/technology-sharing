package com.management.spring.security.threaddemo;

import com.management.spring.security.threaddemo.customthread.MyThreadPool;
import javafx.concurrent.Task;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @Author xiqiuwei
 * @Date Created in 20:22 2020/4/14
 * @Description
 * @Modified By:
 */
public class ThreadDemo {
//    @Autowired
//    private MyThreadPool myThreadPool;


    public static void threadTest() {
        MyThreadPool myThreadPool = new MyThreadPool();
        Callable<Integer> callable1 = () -> {
            // 模拟线程业务耗时
            Thread.sleep(5000);
            String name = Thread.currentThread().getName();
            Integer i = 18;
            if (null == i) {
                throw new Exception("线程" + name + "抛出了异常,返回值类型不能为空");
            }
            return i;
        };
        Callable<Integer> callable2 = () -> {
            Thread.sleep(3000);
            return 25;
        };

        Runnable runnable1 = () -> System.out.println("这是无返回结果的runnable接口");

        try {
            Future<?> result1 = myThreadPool.submit(callable1);
            Future<?> result2 = myThreadPool.submit(callable2);
            myThreadPool.execute(runnable1);
            System.out.println("因为callable中执行的任务比较耗时,我先执行这里的逻辑");
            System.out.println("这里我去拿线程池的返回结果合:" + ((Integer) result1.get() + (Integer) result2.get()));
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            myThreadPool.shutdown();
        }

    }

    public static void main(String[] args) throws InterruptedException {
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
//        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                long start = new Date().getTime();
//                System.err.println("Thread Start Time========》"+ DateFormat.getTimeInstance().format(new Date()));
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                long end = new Date().getTime();
//                System.err.println("Execute Thread: "+ (end - start) + " Time Unit: MILLISECONDS");
//                System.err.println("《=========Thread End Time: " + DateFormat.getTimeInstance().format(new Date()));
//            }
//        },0,5000, TimeUnit.MILLISECONDS);
        //threadTest();
//        CountDownLatch countDownLatch = new CountDownLatch(2);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println("子线程1执行完后等待");
//                    Thread.sleep(5000);
//                    countDownLatch.countDown();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("子线程2执行完后等待");
//                countDownLatch.countDown();
//            }
//        }).start();
//        countDownLatch.await();
//        System.out.println("最后执行主线程");
    }

}
