package com.lxtx.base.collection;

import java.util.StringJoiner;

/**
 * @author 孙洪波
 * @version 1.0
 * @description
 * @date 2020/11/18
 **/
public class StringJoinTest {
    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(",");
        stringJoiner.add("hello");
        stringJoiner.add("guys");
        stringJoiner.add("欢迎关注公众号Java技术栈");
        System.out.println(stringJoiner.toString());
    }
}
