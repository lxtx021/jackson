package com.lxtx.designmodel;

/**
 * 懒汉式
 * 1)线程不安全，不可用
 * https://mp.weixin.qq.com/s?__biz=MzI3ODcxMzQzMw==&mid=2247483742&idx=1&sn=9429b26871f19e4dafd1bf0c7ec0520e&chksm=eb538468dc240d7e968486dbdb7fa440b365ac81a3d9920013781776b601754b1a0659b92b70&scene=21#wechat_redirect
 * @author sun
 */
public class Singleton {

    private static Singleton instance;

    private Singleton (){}



    public static Singleton getInstance() {

        if (instance == null) {

            instance = new Singleton();

        }

        return instance;

    }

}