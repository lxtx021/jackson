package com.lxtx.easyexcel;

import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.collections.CollectionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EasyExcelTest {
    public static void main(String[] args) {

        String path = "C:\\Users\\jackson\\Desktop\\temp\\as.xlsx";
        try {
            File file =new File(path);
            InputStream inputStream = new FileInputStream(file);
//            InputStream inputStream = FileUtil.getResourcesFileInputStream("as.xlsx");
//            List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(0, 1, ShareInfoBean.class));
            List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
            inputStream.close();
            if(CollectionUtils.isNotEmpty(data)){
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
