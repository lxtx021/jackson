package com.lxtx.base.io;

import java.io.File;
import java.util.Calendar;

/**
 * file test
 * 测试指定文件目录中的文件的最后更新时间，超过七天，删除。
 * 为项目中的定时job 写功能逻辑。
 * @author jackson
 */
public class FileTest {
    public static void main(String[] args) {
        String dir = "F:\\2\\";
        File directory = new File("F:\\2");
        File[] files = directory.listFiles();
        Calendar cal =Calendar.getInstance();
        long now = cal.getTimeInMillis();
        long day = 24*60*60*1000;
        long deadLine = now-7*day;
        if(files.length>0){
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                if(file.isDirectory()){
                    // 文件是个目录
                    System.out.println("目录："+file.getName());

                }else{
                    System.out.println(file.getName());
                    long time = file.lastModified();
                    if(time<deadLine){
                        System.out.println("文件最后更新时间超过七天，后台强制删除。");
                        // 当前时间-7天，如果超过七天，文件删除
                        file.delete();
                        // jvm 退出的时候才删除文件，也就是程序执行完再删除文件，不建议使用
                        /*try {
                            FileUtils.forceDeleteOnExit(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }*/
                    }
                }

                System.out.println();
            }
        }


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
