package com.lxtx.designmodel;

/**
 * 饿汉式
 * 双重校验锁，线程安全，推荐使用
 * @author sun
 */
public class Singleton6 {

    private static volatile Singleton6 Singleton6;

    private Singleton6() {}

    public static Singleton6 getInstance() {

        if (Singleton6 == null) {

            synchronized (Singleton6.class) {

                if (Singleton6 == null) {

                    Singleton6 = new Singleton6();

                }

            }

        }

        return Singleton6;

    }

} 
