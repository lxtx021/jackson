package com.lxtx.base.collection;

/**
 * @author jackson
 * @version 1.0
 * @description
 * Java中的String类提供了支持正则表达式操作的方法，包括：matches()、replaceAll()、replaceFirst()、split()。
 * 此外，Java中可以用Pattern类表示正则表达式对象，它提供了丰富的API进行各种正则表达式操作，如：
 * @date 2021/8/24
 **/
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegExpTest {
    public static void main(String[] args) {
        String str = "成都市(成华区)(武侯区)(高新区)";
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }
    }
}