package com.lxtx.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 孙洪波
 * @version 1.0
 * @description 著作权归https://pdai.tech所有。
 * 链接：https://www.pdai.tech/md/java/thread/java-thread-x-theorty.html
 * 线程不安全示例 如果多个线程对同一个共享数据进行访问而不采取同步操作的话，那么操作的结果是不一致的。
 * 以下代码演示了 1000 个线程同时对 cnt 执行自增操作，操作结束之后它的值有可能小于 1000。
 * @date 2021/7/28
 **/
public class ThreadUnsafeExampleTest {
    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                example.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.get());
    }
}
