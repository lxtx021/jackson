package com.lxtx.base.io;

import java.io.File;
import java.util.Calendar;

/**
 * file test
 * 测试指定文件目录中的文件的最后更新时间，超过七天，删除。
 * 为项目中的定时job 写功能逻辑。
 * @author jackson
 */
public class FileTest2 {
    public static void main(String[] args) {
        String dir = "C:\\Users\\sun\\Desktop\\logs\\20190715";
        File directory = new File(dir);
        File[] files = directory.listFiles();
        if (files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                if (file.isDirectory()) {
                    // 文件是个目录
                    System.out.println("目录：" + file.getName());

                } else {
                    System.out.println(file.getName()+":"+file.length()/1024/1024);
                }

//                System.out.println();
            }
        }
    }
}
