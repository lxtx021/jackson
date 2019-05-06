package com.lxtx.base.names;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sun
 */
public class NameDefine {
    private static boolean checked;
    public static final String YES = "yes";
    public static final String YES2 = "yes";
    public static void main(String[] args) {
        // 命名规则
        /**
         * 【强制】 POJO 类中布尔类型的变量，都不要加 is，否则部分框架解析会引起序列化错误。
         * 反例： 定义为基本数据类型 Boolean isDeleted； 的属性，它的方法也是 isDeleted()， RPC阿里巴巴 Java 开发手册
         * 框架在反向解析的时候， “以为”对应的属性名称是 deleted，导致属性获取不到，进而抛出异常。
         */
//        checked=true;
        System.out.println("boolean默认值"+checked);
        /**
         * 13. 【推荐】接口类中的方法和属性不要加任何修饰符号（public 也不要加） ，保持代码的简洁
         * 性，并加上有效的 Javadoc 注释。尽量不要在接口里定义变量，如果一定要定义变量，肯定是
         * 与接口方法相关，并且是整个应用的基础常量。
         * 正例： 接口方法签名： void f();
         * 接口基础常量表示： String COMPANY = "alibaba";
         * 反例： 接口方法定义： public abstract void f();
         * 说明： JDK8 中接口允许有默认实现，那么这个 default 方法，是对所有实现类都有价值的默
         * 认实现。
         */
        System.out.println(YES.equals(YES2));

        Date date =new Date();
        DateFormat df =new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(date));


        /**
         *  【推荐】使用索引访问用 String 的 split 方法得到的数组时，需做最后一个分隔符后有无
         *   内容的检查，否则会有抛 IndexOutOfBoundsException 的风险。
         *   Array 中间元素如果为空，也算做数据量
         */
        String str = "a,b,,c,,";
        String[] ary = str.split(",");
        // 预期大于 3，结果是
        System.out.println(ArrayUtils.getLength(ary));
        System.out.println(ary.length);
        if(ArrayUtils.isNotEmpty(ary)){
            for (String a :ary) {
                System.out.println(a);
            }
        }
    }
}
