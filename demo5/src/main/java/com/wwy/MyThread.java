package com.wwy;

/**
 * @Author: wwy
 * @Date: 2019-05-17 19:22
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
