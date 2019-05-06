package com.lxtx.base.collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {
        /**
         * 【强制】使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全
         * 一样的数组，大小就是 list.size()。
         * 说明： 使用 toArray 带参方法，入参分配的数组空间不够大时， toArray 方法内部将重新分配
         * 内存空间，并返回新数组地址； 如果数组元素大于实际所需，下标为[ list.size() ]的数组
         * 元素将被置为 null，其它数组元素保持原值，因此最好将方法入参数组大小定义与集合元素
         * 个数一致。
         */
        List<String> list = new ArrayList<String>(2);
        list.add("guan");
        list.add("bao");
        String[] array = new String[list.size()];
        array = list.toArray(array);
        if(CollectionUtils.isNotEmpty(list)){
            for (String str :
                    list) {
                System.out.println(str);
            }
        }

        if(ArrayUtils.isNotEmpty(array)){
            for (String str :  array) {
                System.out.println(str);
            }
        }
        /**
         * 反例： 直接使用 toArray 无参方法存在问题，此方法返回值只能是 Object[]类，若强转其它
         * 类型数组将出现 ClassCastException 错误。
         */

        /**
         * 【强制】使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方
         * 法，它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。
         * 说明： asList 的返回对象是一个 Arrays 内部类，并没有实现集合的修改方法。Arrays.asList
         * 体现的是适配器模式，只是转换接口，后台的数据仍是数组。
         */

        String[] str = new String[] { "you", "wu" };
        List<String> list2 = Arrays.asList(str);
        for (String st:list2) {
            System.out.println(st);
        }
    }
}
