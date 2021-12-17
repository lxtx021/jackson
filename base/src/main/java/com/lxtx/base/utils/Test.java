package com.lxtx.base.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    /*public static void main(String[] args) {
        System.out.println(JdkVersion.getMajorJavaVersion());

        String str = "RPT-20170105-51C8D6FB-0001";
        String a =StringUtils.substring(str,4,8);
        System.out.println(a);
        int year = Integer.parseInt(a);

        String b="CAAC20200001";
        String c =StringUtils.substring(b,8,12);
        System.out.println(c);
//        System.out.println(year);

    }*/
    /**
     * 验证密码强度，至少8位
     * 这个正则表达式将强制执行这些规则：
     * – 至少1个大写英文字母
     * – 至少1个小写英文字母
     * – 至少1位数字
     * – 至少1个特殊字符
     * – 最少8个长度
     * @param str
     * @return
     */
    public static boolean checkPasswordStrength(String str){
        String regex = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        if (m.matches()) {
//			System.out.println("匹配");
            return true;

        } else {
//			System.out.println("不匹配");
            return false;
        }
    }

    public static void main(String[] args) {
        String str="A1scdscs@";
        boolean status = checkPasswordStrength(str);
        System.out.println(status);
    }
}

