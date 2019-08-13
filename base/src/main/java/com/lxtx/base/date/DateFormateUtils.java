package com.lxtx.base.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1.自己写公用类的时候，要对多线程调用情况下的后果在注释里进行明确说明
 * 2.多线程环境下，对每一个共享的可变变量都要注意其线程安全性
 * 3.我们的类和方法在做设计的时候，要尽量设计成无状态的
 */
public class DateFormateUtils {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatDate(Date date) throws ParseException {
        return sdf.format(date);
    }

    public static Date parse(String strDate) throws ParseException {
        return sdf.parse(strDate);
    }
}
