package com.lxtx.base.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

class Temp extends Thread {
    @Override
    public void run() {
        System.out.println("run");
    }
}

/**
 * 线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，
 * 这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。
 * 说明：Executors各个方法的弊端：
 *      1）newFixedThreadPool和newSingleThreadExecutor:
 *        主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至OOM。
 *      2）newCachedThreadPool和newScheduledThreadPool:
 *        主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM。
 *
 *      Positive example 1：
 *      //org.apache.commons.lang3.concurrent.BasicThreadFactory
 *      ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
 *      new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
 *
 *
 *
 *      Positive example 2：
 *      ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
 *      .setNameFormat("demo-pool-%d").build();
 *
 *      //Common Thread Pool
 *      ExecutorService pool = new ThreadPoolExecutor(5, 200,
 *      0L, TimeUnit.MILLISECONDS,
 *      new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
 *
 *      pool.execute(()-> System.out.println(Thread.currentThread().getName()));
 *      pool.shutdown();//gracefully shutdown
 *
 *      Positive example 3：
 *      <bean id="userThreadPool"
 *      class="org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor">
 *      <property name="corePoolSize" value="10" />
 *      <property name="maxPoolSize" value="100" />
 *      <property name="queueCapacity" value="2000" />
 *
 *      <property name="threadFactory" value= threadFactory />
 *      <property name="rejectedExecutionHandler">
 *      <ref local="rejectedExecutionHandler" />
 *      </property>
 *      </bean>
 *      //in code
 *      userThreadPool.execute(thread);
 * @author jackson
 */
public class ScheduledJob {

    public static void main(String args[]) throws Exception {
    
    	Temp command = new Temp();
        ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(1,new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> scheduleTask  = scheduler.scheduleWithFixedDelay(command, 5, 1, TimeUnit.SECONDS);
        //        ScheduledFuture<?> scheduleTask = scheduler.scheduleWithFixedDelay(command, 5, 1, TimeUnit.SECONDS);


      /*  //  ThreadFactory
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(5, 200,0L, TimeUnit.MILLISECONDS,
        new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        pool.shutdown();//gracefully shutdown*/
    }
}