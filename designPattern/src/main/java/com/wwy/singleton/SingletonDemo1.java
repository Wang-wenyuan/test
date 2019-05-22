package com.wwy.singleton;

/**
 * @Author: wwy
 * @Date: 2019-05-21 10:06
 * 懒汉式单列
 */
public class SingletonDemo1 {
    private static volatile SingletonDemo1 instance = null;
    private SingletonDemo1(){

    }
    public static synchronized SingletonDemo1 getInstance(){

        if(instance == null){
            instance = new SingletonDemo1();
        }
        return instance;
    }
}
