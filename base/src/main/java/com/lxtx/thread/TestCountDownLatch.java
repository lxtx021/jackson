package com.lxtx.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author jackson
 * @version 1.0
 * @description CountDownLatch
 * 解释：
 * CountDownLatch相当于一个门闩，门闩上挂了N把锁。只有N把锁都解开的话，门才会打开。怎么理解呢？我举一个赛跑比赛的例子，赛跑比赛中必须等待所有选手都准备好了，裁判才能开发令枪。选手才可以开始跑。
 * CountDownLatch当中主要有两个方法，一个是await()会挂上锁阻塞当前线程，相当于裁判站在起始点等待，等待各位选手准备就绪，一个是countDown方法用于解锁，相当于选手准备好了之后调用countDown方法告诉裁判自己准备就绪，当所有人都准备好了之后裁判开发令枪。
 * https://mp.weixin.qq.com/s?__biz=MzU2MTI4MjI0MQ==&mid=2247504906&idx=2&sn=0d491e105fb4ca9665229818eda9e586&chksm=fc79b9a4cb0e30b28abd8fa0c10764dd0f804afc2b410c953d8f15546736e7738a28b74f9b47&scene=132#wechat_redirect
 * @date 2021/6/9
 **/
public class TestCountDownLatch {
    public static void main(String[] args) {
        // 需要等待两个线程，所以传入参数为2
        CountDownLatch latch = new CountDownLatch(2);
        // 该线程运行1秒
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1号选手准备就绪！用时1秒！");
                latch.countDown();
            }
        }).start();

        // 该线程运行3秒
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2号选手准备就绪！用时3秒！");
                latch.countDown();
            }
        }).start();

        try {
            System.out.println("请1号选手和2号选手各就各位！");
            // 主线程在此等待两个线程执行完毕之后继续执行
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 两个线程执行完毕后，主线程恢复运行
        System.out.println("裁判发枪，1号选手和2号选手开跑！");
    }
}
