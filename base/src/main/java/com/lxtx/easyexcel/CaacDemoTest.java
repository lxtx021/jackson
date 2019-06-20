package com.lxtx.easyexcel;

import com.lxtx.pinyin.PinyinUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CaacDemoTest {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径
        String userDir = System.getProperty("user.dir");
        String path = "D:\\adcc\\CAAC.xlsx";

        try {
            File file =new File(path);
            if(file.exists()){
                System.out.println("asasas");
            }
//            InputStream inputStream = FileUtil.getResourcesFileInputStream(path);
            InputStream is = new FileInputStream(path);
            InputStream inputStream = new BufferedInputStream(is);
            XSSFWorkbook xworkBook = new XSSFWorkbook(is);
              /*  XSSFSheet sheet2 = xworkBook.getSheetAt(2);
            System.out.println(sheet2.getLastRowNum());
            Map<String,String> map = new HashMap<>(50);
            for (int j = 1; j < sheet2.getLastRowNum()+1; j++) {
                Row row = sheet2.getRow(j);
                String name = row.getCell(0).toString();
//                map.put(name,name);
                System.out.println(name);
            }*/

            XSSFSheet xssfSheet = xworkBook.getSheetAt(1);
            OutputStream outputStream = new FileOutputStream(path);
            for (int i = 1; i < xssfSheet.getLastRowNum()+1; i++) {
                Row row = xssfSheet.getRow(i);
                String name = row.getCell(5).toString();
                // 根据汉字转拼音
                String pinyin = PinyinUtil.ToPinyin(name);
                row.getCell(12).setCellValue(pinyin);
                row.getCell(13).setCellValue("v2fdgCV+WN77P3BHxrm8R4ToaYi8aBcybaCAt45h+pjJPDzaOCLjDGYn1vHRn0IIIUAr7Z7QMhCWC7Sp+FehqQ==");
                /*if(StringUtils.isNotBlank(map.get(name))){
                    // 重复数据
                    row.getCell(14).setCellValue(0);
                }else{
                    // 正常数据
                    row.getCell(14).setCellValue(1);
                }*/
//                System.out.println(name);
//                System.out.println("姓名："+name+",拼音："+pinyin);
            }
            xworkBook.write(outputStream);
            if(outputStream!=null){
                outputStream.close();
            }
            if(inputStream!=null){
                inputStream.close();
            }
            if(is!=null){
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
