package com.lxtx.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author 孙洪波
 * @version 1.0
 * @description
 * @date 2021/7/13
 **/
class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"\t come in Callable");
        // 逻辑代码
        return 1024;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws Exception{
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread());
        FutureTask<Integer> futureTask2 = new FutureTask<Integer>(new MyThread());
        // t1，t2线程公用一个futureTask不可行，需要再创建
        new Thread(futureTask,"t1").start();
        //new Thread(futureTask,"t2").start();
        new Thread(futureTask2,"t2").start();
        // futureTask.get()获得Callable线程的计算结果，尽量放在后面，会阻塞线程的运行
        int result = futureTask.get();
        System.out.println(result);
    }
}