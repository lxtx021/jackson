package com.lxtx.designmodel;

/**
 * 懒汉式
 * 静态内部类，线程安全，主动调用时才实例化，延迟加载效率高，推荐使用
 * @author sun
 */
public class Singleton7 {

    private static class Singleton7Holder {

        private static final Singleton7 INSTANCE = new Singleton7();

    }

    private Singleton7 (){}

    public static final Singleton7 getInstance() {

        return Singleton7Holder.INSTANCE;

    }

}


