package com.lxtx.base.collection;

import org.apache.commons.lang3.StringUtils;

/**
 * @author jackson
 */
public class StringUtilsTest {
    public static void main(String[] args) {
        String a = "java";
        String b = "jdk";
        /**
         * StringUtils.compareIgnoreCase(null, null)   = 0
         * StringUtils.compareIgnoreCase(null , "a")   &lt; 0
         * StringUtils.compareIgnoreCase("a", null)    &gt; 0
         * StringUtils.compareIgnoreCase("abc", "abc") = 0
         * StringUtils.compareIgnoreCase("abc", "ABC") = 0
         * StringUtils.compareIgnoreCase("a", "b")     &lt; 0
         * StringUtils.compareIgnoreCase("b", "a")     &gt; 0
         * StringUtils.compareIgnoreCase("a", "B")     &lt; 0
         * StringUtils.compareIgnoreCase("A", "b")     &lt; 0
         * StringUtils.compareIgnoreCase("ab", "ABC")  &lt; 0
         */
        int i = StringUtils.compareIgnoreCase(a,b);
        System.out.println(i);
        int sta1 = StringUtils.indexOf(a,"j");
        System.out.println("指定字符串的位置（从0开始）："+sta1);

        int c =StringUtils.ordinalIndexOf(a,"a",2);
        System.out.println("ordinalIndexOf(从指定位置开始查找第一个符合条件的字符串的位置)"+c);
    }
}
