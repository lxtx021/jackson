package com.lxtx.base.utils;

import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileNameTest {
    public static void main(String[] args) {
        String fileName = "！%2&#.pdf";
        Pattern pattern = Pattern.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]");
        Pattern pattern2 = Pattern.compile("[\\\\/:*?\"<>|]");
        Matcher matcher = pattern.matcher(fileName);
        fileName= matcher.replaceAll(""); // 将匹配到的非法字符以空替换
        System.out.println(fileName);

        Matcher matcher2 = pattern2.matcher(fileName);
        fileName= matcher2.replaceAll(""); // 将匹配到的非法字符以空替换
        System.out.println("222:"+fileName);


        String a =  fileName.replaceAll("[^a-zA-Z0-9.]", "").replaceAll("\\s+", "_");
        System.out.println(a);
//        FilenameFilter
        String title = "？\\*{}[]%2&#.pdf";
       String str =  title.replaceAll("[\\( \\) \\ \\/ : \\? \\* < > \\| \"]", "-").replaceAll("[-]+", "");//匹配 非法pdf文件名字符
        System.out.println(str);
    }
}
