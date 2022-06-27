package com.lxtx.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 孙洪波
 * @version 1.0
 * @description
 * @date 2022/3/22
 **/
public class Test4 {
    //添加了ReentrantLock锁
    Lock lock = new ReentrantLock();
    private int i=0;
    public static void main(String[] args) {
        Test4 test = new Test4();
        ExecutorService es = Executors.newFixedThreadPool(50);
        CountDownLatch cdl = new CountDownLatch(5000);
        for (int i = 0;i < 5000; i++){
            es.execute(()->{
                //修改部分  开始
                test.lock.lock();
                test.i++;
                test.lock.unlock();
                //修改部分  结束
                cdl.countDown();
            });
        }
        es.shutdown();
        try {
            cdl.await();
            System.out.println("执行完成后，i="+test.i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
