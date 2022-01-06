package com.lxtx.thread;

import java.util.concurrent.Semaphore;

/**
 * @author jackson
 * @version 1.0
 * @description Semaphore
 * Semaphore英文的字面意思是信号量。它的工作机制是每个线程想要获取运行的机会的话，都必须获取到信号量。acquire()方法阻塞的获取信号量，release()释放信号量。
 *
 * 举个例子，假设我们去迪士尼游玩，但是迪士尼担心游客很多的话，影响大家的游玩体验，于是规定每个小时只能卖出两张门票。这样就可以控制在游乐园当中的游客数量了。
 * @date 2021/6/9
 **/
public class TestSemaphore {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(0);
        System.out.println("顾客在售票处等候中");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                    try {
                        Thread.sleep(500);
                        // 等待出票
                        semaphore.acquire();
                        System.out.println("顾客拿到门票入场！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 3; i++) {
                    try {
                        // 等待一小时再发门票
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 一次性发出两张门票
                    System.out.println("售票处第" + (i + 1) + "小时售出两张票！");
                    semaphore.release();
                    semaphore.release();
                }
            }
        }).start();

        System.out.println("售票处开始售票！");
    }
}
