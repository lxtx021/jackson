package com.lxtx.base.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URITest {
    public static void main(String[] args) {
        String str= "01-05-009+可用件和不可用件退库工作程序r2.pdf";
        try {
            String str1= URLEncoder.encode(str,"UTF-8");
            System.out.println(str1);
            String str2 =  URLDecoder.decode(str1,"UTF-8");
            System.out.println(str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
