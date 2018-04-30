package com.lxtx.base.io;

import java.io.File;

/**
 * file test
 * @author jackson
 */
public class FileTest {
    public static void main(String[] args) {
        String dir = "F:\\2\\";
        File directory = new File("F:\\2");
        File[] files = directory.listFiles();

//        System.out.println(files.length);
//        System.out.println("文件数："+files.length);
//        for (File file:files) {
//            System.out.println(file.getName() + ":"+ file.getAbsolutePath());
//        }
        for (int i = 0; i < files.length; i++) {

            /**
             * outputFlage1
             * 输出文件名及其绝对路径
             */
//            System.out.println(i + ":" + files[i].getName() + ";;;"
//                    + files[i].getAbsolutePath());
            //
            String name = files[i].getName();
//            String fileName = name.substring(9);
//            System.out.println(fileName);
//            File as = new File(dir+fileName);
//            System.out.println("--"+as.getName()+":"+as.getAbsolutePath());
//            files[i].renameTo(as);
//            files[i].renameTo(new File(dir + i + files[i].getName()));
            /**
             * outputFlag2
             * 这里可以看出输出的结果和outputFlag一样，renameTo方法没有改变files[i]的值（内存中数据没变），但是改变了文件名
             */
            // System.out.println(files[i].getName());
        }
    }
}
