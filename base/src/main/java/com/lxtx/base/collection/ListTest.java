package com.lxtx.base.collection;

import org.apache.commons.lang3.StringUtils;
import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        String[] str = new String[] { "you", "wu" };
        List<String> list = Arrays.asList(str);
        //Exception in thread "main" java.lang.UnsupportedOperationException
        /**
         * 【强制】使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方
         * 法，它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。
         * 说明： asList 的返回对象是一个 Arrays 内部类，并没有实现集合的修改方法。Arrays.asList
         * 体现的是适配器模式，只是转换接口，后台的数据仍是数组。
         * 第一种情况： list.add("yangguanbao"); 运行时异常。
         * 第二种情况： str[0] = "gujin"; 那么 list.get(0)也会随之修改。
         */
//        list.add("xsaxsa");
//        str[0] = "gujin";
        for(String a: list) {
            System.out.println(a);
        }

        /**
         * 【强制】泛型通配符<? extends T>来接收返回的数据，此写法的泛型集合不能使用 add 方
         *         法， 而<? super T>不能使用 get 方法，作为接口调用赋值时易出错。
         *         说明： 扩展说一下 PECS(Producer Extends Consumer Super)原则： 第一、 频繁往外读取内
         *         容的，适合用<? extends T>。 第二、 经常往里插入的，适合用<? super T>。
         */

        /**
         * 【强制】不要在 foreach 循环里进行元素的 remove/add 操作。 remove 元素请使用 Iterator
         * 方式，如果并发操作，需要对 Iterator 对象加锁
         *
         */
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        Iterator<String> iterator = list2.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
            if (StringUtils.equalsIgnoreCase(item,"1")) {
                iterator.remove();
//                break;
            }
        }

        for (String item : list2) {
            if ("1".equals(item)) {
                list2.remove(item);
                System.out.println("异常："+item);
            }
            System.out.println("正常："+item);
        }

        /**
         * 【推荐】 集合泛型定义时， 在 JDK7 及以上，使用 diamond 语法或全省略。
         *     说明： 菱形泛型，即 diamond， 直接使用<>来指代前边已经指定的类型。
         *     正例：
         */
        // <> diamond 方式
        HashMap<String, String> userCache = new HashMap<>(16);
        // 全省略方式
//    ArrayList<Integer> users = new ArrayList(10);
//    Set<String> set = new HashSet<>(16);
        


    }



}
