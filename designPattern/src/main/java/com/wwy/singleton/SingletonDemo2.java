package com.wwy.singleton;

/**
 * @Author: wwy
 * @Date: 2019-05-21 10:12
 * 饿汉式单列
 */
public class SingletonDemo2 {
    private final static SingletonDemo2 instance = new SingletonDemo2();
    private SingletonDemo2(){

    }
    public static SingletonDemo2 getInstance(){
        return instance;
    }
}
