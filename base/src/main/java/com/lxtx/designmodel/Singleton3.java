package com.lxtx.designmodel;

/**
 * 1、懒汉式
 * 类加载的时候就创建实例
 * 2、饿汉式
 * 使用的时候才创建实例
 * 当然还有其他的生成单例的方式，双重校验锁，枚举和静态内部类，文中会有介绍
 * 懒汉式  线程不安全，会产生多个实例，不可用
 * @author sun
 */
public class Singleton3 {

    private static Singleton3 Singleton3;

    private Singleton3() {}



    public static Singleton3 getInstance() {

        if (Singleton3 == null) {

            synchronized (Singleton3.class) {

                Singleton3 = new Singleton3();

            }

        }

        return Singleton3;

    }

}