package com.lxtx.easyexcel;

import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.collections.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EasyExcelTest {
    public static void main(String[] args) {

        String path = "C:\\Users\\jackson\\Desktop\\temp\\as.xlsx";
        try {
            File file =new File(path);
            if(file.exists()){
                System.out.println("asasas");
            }
            InputStream inputStream = FileUtil.getResourcesFileInputStream("as.xlsx");
            if(inputStream==null){
                System.out.println(false);
            }else{
                System.out.println(true);
            }
            List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 2));

            inputStream.close();
            if(CollectionUtils.isNotEmpty(data)){
                System.out.println(data.size());
                for (Object obj :data) {
                    ShareInfoBean bean = (ShareInfoBean)obj;
                    System.out.println(bean.getName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
