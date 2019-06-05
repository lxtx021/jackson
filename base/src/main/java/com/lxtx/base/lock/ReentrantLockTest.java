package com.lxtx.base.lock;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private ReentrantLock lock = new ReentrantLock();
    public void run() {
        lock.lock();
        try {
            //do bussiness
            System.out.println(new Date().toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
