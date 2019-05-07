package com.lxtx.base.collection;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 【强制】 SimpleDateFormat 是线程不安全的类，一般不要定义为 static 变量，如果定义为
 * static，必须加锁，或者使用 DateUtils 工具类。
 * 正例： 注意线程安全，使用 DateUtils。亦推荐如下处理：
 * private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
 * @Override
 * protected DateFormat initialValue() {
 * return new SimpleDateFormat("yyyy-MM-dd");
 * }
 * };
 * 说明： 如果是 JDK8 的应用，可以使用 Instant 代替 Date， LocalDateTime 代替 Calendar，
 * DateTimeFormatter 代替 SimpleDateFormat，官方给出的解释： simple beautiful strong
 * immutable thread-safe。
 * @author jackson
 */
public class DateUtilsTest {
    private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };
    public static void main(String[] args) {
//        System.out.println(LocalDateTime.now().toString());

        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.now();
        String text = date.format(formatter);
        System.out.println(text);
        LocalDate parsedDate = LocalDate.parse(text, formatter);
        System.out.println(parsedDate.toString());

        System.out.println(Calendar.getInstance().getTimeInMillis());

        System.out.println("--------------------------------------");
        System.out.println(Instant.EPOCH);
        System.out.println(Instant.MAX);
        System.out.println(Instant.MIN);
        System.out.println(Instant.now());

        System.out.println("--------------------------------------");
        /**
         * 【参考】 volatile 解决多线程内存不可见问题。对于一写多读，是可以解决变量同步问题，
         * 但是如果多写，同样无法解决线程安全问题。如果是 count++操作，使用如下类实现：
         * AtomicInteger count = new AtomicInteger(); count.addAndGet(1); 如果是 JDK8，推
         * 荐使用 LongAdder 对象，比 AtomicLong 性能更好（减少乐观锁的重试次数） 。
         */
        AtomicInteger count = new AtomicInteger();
        count.addAndGet(1);
        System.out.println(count);
        AtomicLong l =new AtomicLong(20L);

        System.out.println(l);
    }
}
