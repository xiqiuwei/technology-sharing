package com.management.spring.security.threaddemo;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author xiqiuwei
 * @Date Created in 20:22 2020/4/14
 * @Description
 * @Modified By:
 */
public class ThreadDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                long start = new Date().getTime();
                System.err.println("Thread Start Time========》"+ DateFormat.getTimeInstance().format(new Date()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long end = new Date().getTime();
                System.err.println("Execute Thread: "+ (end - start) + " Time Unit: MILLISECONDS");
                System.err.println("《=========Thread End Time: " + DateFormat.getTimeInstance().format(new Date()));
            }
        },0,5000, TimeUnit.MILLISECONDS);

    }
}
