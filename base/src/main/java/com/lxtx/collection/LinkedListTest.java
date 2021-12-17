package com.lxtx.collection;

import java.util.LinkedList;

/**
 * @author 孙洪波
 * @version 1.0
 * @description
 * @date 2020/8/21
 **/
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> lList = new LinkedList<String>();
        lList.add("1");
        lList.add("2");
        lList.add("3");
        lList.add("4");
        lList.add("5");
        lList.add(2,"hahah");
        lList.offer("asas");
        // 先进先出 从队列首出去
        lList.pop();
        // 插入到队列首部
        lList.push("ZZZasas");
        lList.remove(0);
        for (String str :lList) {
            System.out.println(str);
        }

        System.out.println("链表的第一个元素是 : " + lList.getFirst());
        System.out.println("链表最后一个元素是 : " + lList.getLast());
    }
}
