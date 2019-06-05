package com.lxtx.thread;

public class ThreadTest1 {
    public static void main(String[] args) {
        /*Thread t =new Thread();
        t.start();
        t.run();
        t.interrupt();
        t.setPriority(Thread.NORM_PRIORITY);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Thread thread =Thread.currentThread();
        System.out.println(thread.getId());
        System.out.println(thread.getState().name());
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
        System.out.println(thread.getClass().getName());
    }
}
