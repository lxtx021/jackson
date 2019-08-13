package com.lxtx.base.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FormatDateTimeTest {
    public static void main(String[] args) {
        dateFormat2();
    }
    public static void dateFormat1(){
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        SimpleDateFormat myFmt1 = new SimpleDateFormat("yy/MM/dd HH:mm");
        SimpleDateFormat myFmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//等价于now.toLocaleString()
        SimpleDateFormat myFmt3 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");
        SimpleDateFormat myFmt4 = new SimpleDateFormat("一年中的第 D 天 一年中第w个星期 一月中第W个星期 在一天中k时 z时区");
        Date now = new Date();
        System.out.println(myFmt.format(now));
        System.out.println(myFmt1.format(now));
        System.out.println(myFmt2.format(now));
        System.out.println(myFmt3.format(now));
        System.out.println(myFmt4.format(now));
        System.out.println(now.toGMTString());
        System.out.println(now.toLocaleString());
        System.out.println(now.toString());
    }
    /**
     * 2018年06月19日 23时10分05秒
     * 18/06/19 23:10
     * 2018-06-19 23:10:05
     * 2018年06月19日 23时10分05秒 星期二
     * 一年中的第 170 天 一年中第25个星期 一月中第4个星期 在一天中23时 CST时区
     * 19 Jun 2018 15:10:05 GMT
     * 2018-6-19 23:10:05
     * Tue Jun 19 23:10:05 CST 2018
     */
    /**
     * Java 8 提供了新的日期时间 API，其中包括用于日期时间格式化的 DateTimeFormatter，
     * 它与 SimpleDateFormat 最大的区别在于：DateTimeFormatter 是线程安全的，而 SimpleDateFormat 并不是线程安全。
     */
    public static void dateFormat2(){
        // 1、解析日期
        String dateStr= "2018年06月20日";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        LocalDate date= LocalDate.parse(dateStr, formatter);
        System.out.println("date:"+date);
        // 2、日期转换为字符串
        LocalDateTime now = LocalDateTime.now();
        Date da =new Date();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss");
        String nowStr = now .format(format);
        System.out.println("now:"+nowStr);

        // 由 DateTimeFormatter 的静态方法 ofPattern() 构建日期格式，LocalDateTime 和 LocalDate 等一些表示日期或时间的类使用 parse 和 format 方法把日期和字符串做转换。使用新的 API，整个转换过程都不需要考虑线程安全的问题。
        // SimpleDateFormat 是线程不安全的类，多线程环境下注意线程安全问题，如果是 Java 8 ，建议使用 DateTimeFormatter 代替 SimpleDateFormat。
        // http://www.54tianzhisheng.cn/2018/06/19/SimpleDateFormat/
    }
}
