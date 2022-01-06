package com.lxtx.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jackson
 * @version 1.0
 * @description
 * @date 2021/5/20
 **/
public class TestSet {
    public static void main(String[] args) {
        Set<Employee> emps = new HashSet<>();
        Employee zhangsan = new Employee(1, "张三");
        Employee lisi  = new Employee(2, "李四");
        Employee wangwu  = new Employee(1, "张三");
        emps.add(wangwu);
        emps.add(lisi);
        emps.add(zhangsan);
        Employee zhaoliu  = new Employee(5, "李四");
        System.out.println("contains:"+emps.contains(zhaoliu));
        emps.forEach(System.out::println);
    }
}
