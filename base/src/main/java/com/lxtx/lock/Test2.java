package com.lxtx.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 孙洪波
 * @version 1.0
 * @description 乐观锁
 * @date 2022/3/22
 **/
public class Test2 {
    private AtomicInteger i = new AtomicInteger(0);
    public static void main(String[] args) {
        Test2 test = new Test2();
        ExecutorService es = Executors.newFixedThreadPool(50);
        CountDownLatch cdl = new CountDownLatch(5000);
        for (int i = 0;i < 5000; i++){
            es.execute(()->{
                test.i.incrementAndGet();
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
