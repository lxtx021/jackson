package com.lxtx.base.collection;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * List 测试数据
 * @author sun
 */
public class ListTest2 {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>(10);
        Map<String,String> map =new HashMap<>(2);

        Map<String,String> map2 =new ConcurrentHashMap<>(16);

        ReentrantLock lock =new ReentrantLock();
        lock.lock();
        lock.unlock();
        // 读写锁
        // 使用 ReentrantReadWriteLock ,同时维护一对锁：读锁和写锁。当写线程访问时则其他所有锁都将阻塞，读线程访问时则不会。通过读写锁的分离可以很大程度的提高并发量和吞吐量。
        ReentrantReadWriteLock rrwLock =new ReentrantReadWriteLock();

        // 测试 lock

    }
}
