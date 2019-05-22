package com.wwy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: wwy
 * @Date: 2019-05-17 19:22
 */
public class Demo1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(new Runnable() {
            public void run() {

            }
        });

    }
}
