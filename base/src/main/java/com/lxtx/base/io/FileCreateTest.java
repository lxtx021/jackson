package com.lxtx.base.io;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;

public class FileCreateTest {
    public static void main(String[] args) throws IOException {
        String[] str1 =new String[]{
               "XJMeasuresUnset","XJMeasuresTaking","XJRiskVerifing","XJRiskPostpone","XJRiskClosed","XJRiskReturned"
        };
        String[] str2 =new String[]{
               "XJTraceUnset","XJTraceTaking","XJTraceVerifing","XJTracePostpone","XJTraceClosed","XJTraceReturned"
        };

        String risk = "E://risk//";
        String trace = "E://trace//";
        for (String s :str1) {
            s=StringUtils.lowerCase(s);
            String path =risk+s+".js";
            File f =new File(path);
            if(!f.exists()){
                f.createNewFile();
            }
        }
        for (String s :str2) {
            s=StringUtils.lowerCase(s);
            String path =trace+s+".js";
            File f =new File(path);
            if(!f.exists()){
                f.createNewFile();
            }
        }
    }
}
