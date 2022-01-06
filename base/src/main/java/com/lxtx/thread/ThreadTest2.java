package com.lxtx.thread;

/**
 * @author jackson
 * @version 1.0
 * @description
 * @date 2021/6/9
 **/
public class ThreadTest2 {
    public static void main(String[] args) {
        Thread thread=new Thread(){
            @Override
            public void run() {
//                super.run();
                System.out.println("hello,我是一个线程!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        thread.start();
    }
}
