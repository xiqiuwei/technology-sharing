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
        Callable<Integer> callable1 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        };
        Callable<Integer> callable2 = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 2;
            }
        };
        try {
            Integer submit1 = (Integer) myThreadPool.submit(callable1);
            Integer submit2 = (Integer) myThreadPool.submit(callable2);
            System.err.println(submit1);
            System.err.println(submit2);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } finally{
            myThreadPool.shutdown();
        }

    }

    public static void main(String[] args) {
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
        threadTest();
    }
}
