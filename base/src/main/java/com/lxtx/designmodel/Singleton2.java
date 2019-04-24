package com.lxtx.designmodel;

/**
 * 懒汉式
 * 2)线程安全，同步方法，效率低，不推荐
 * @author sun
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2 (){}

    public static synchronized Singleton2 getInstance() {

        if (instance == null) {

            instance = new Singleton2();

        }

        return instance;

    }

}