package com.lxtx.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author jackson
 * @version 1.0
 * @description
 * @date 2021/6/9
 **/
public class ThreadStopTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(){
            @Override
            public void run() {
                System.out.println("start");
                boolean flag =true;
                while (flag){
                    ;
                }
                System.out.println("end");
            }
        };
        thread1.setName("thread1");
        thread1.start();
        // 当前线程休眠1秒
        TimeUnit.SECONDS.sleep(1);
        // 关闭线程 thread
        thread1.stop();
        // 输出线程1的状态
        System.out.println(thread1.getState());
        // 当前线程休眠1秒
        TimeUnit.SECONDS.sleep(1);
        // 输出线程1的状态
        System.out.println(thread1.getState());
    }
}
