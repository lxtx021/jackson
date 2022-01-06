package com.lxtx.base.collection;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jackson
 * @version 1.0
 * @description  List 去重
 * @date 2021/12/20
 **/
public class ListDistinctExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(3);
            add(5);
            add(2);
            add(1);
            add(3);
            add(7);
            add(2);
        }};
        System.out.println("原集合:" + list);
//        method_1(list);
//        method_2(list);
//        method_3(list);
//        method_4(list);
        method_5(list);
    }
    /**
     * 使用迭代器去重
     * @param list
     */
    public static void method_1(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            // 获取循环的值
            Integer item = iterator.next();
            // 如果存在两个相同的值
            if (list.indexOf(item) != list.lastIndexOf(item)) {
                // 移除最后那个相同的值
                iterator.remove();
            }
        }
        System.out.println("去重集合:" + list);
    }

    /**
     * 使用 HashSet 去重
     * @param list
     */
    public static void method_2(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>(list);
        System.out.println("去重集合:" + set);
    }

    /**
     * 使用 LinkedHashSet 去重
     * @param list
     */
    public static void method_3(List<Integer> list) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>(list);
        System.out.println("去重集合:" + set);
    }

    /**
     * 使用 TreeSet 去重(无序)
     * @param list
     */
    public static void method_4(List<Integer> list) {
        TreeSet<Integer> set = new TreeSet<>(list);
        System.out.println("去重集合:" + set);
    }
    /**
     * 使用 Stream 去重
     * @param list
     */
    public static void method_5(List<Integer> list) {
        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println("去重集合:" + list);
    }
}
