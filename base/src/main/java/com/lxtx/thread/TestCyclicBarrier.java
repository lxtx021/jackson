package com.lxtx.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 孙洪波
 * @version 1.0
 * @description CyclicBarrier
 * 解释：
 * CyclicBarrier就像一个栅栏，将各个线程拦住。Cyclic是循环的英文，表明该工具可以进行循环使用。CyclicBarrier(N)的构造参数表明该一共有几个线程需要互相等待。它相当于N个选手约定进行多次比赛，每次比赛完都要在起跑点互相等待。
 *
 * 读者可能会马上疑惑这不是和CountDownLatch一样吗？不一样。因为CountDownLatch是裁判等待选手，是调用await()方法的线程，等待调用countDown()方法的各个线程。而CyclicBarrier是选手等待选手，是调用await()方法的线程互相等待，等待其他线程都运行好之后，再开始下一轮运行。
 *
 * 我们举一个例子，两个选手进行比赛，一共进行三轮比赛。
 * @date 2021/6/9
 **/
public class TestCyclicBarrier {
    // 1号选手跑的轮数
    public static int countA = 1;
    // 2号选手跑的轮数
    public static int countB = 1;
    public static void main(String[] args) {
        // 填入2,代表2个线程互相等待
        CyclicBarrier barrier = new CyclicBarrier(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 一共跑三轮
                for (int i = 0; i < 3; i++) {
                    System.out.println("1号选手开始跑！当前第" + countA++ + "轮比赛！");
                    // 1号选手跑得慢，每次跑三秒
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println("1号选手抵达终点！");
                        // 调用等待方法，在此等待其他选手
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                // 一共等待三轮
                for (int i = 0; i < 3; i++) {
                    System.out.println("2号选手开始跑！当前第" + countB++ + "轮比赛！");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println("2号选手抵达终点！");
                        // 调用等待方法，在此等待其他选手
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
