package com.lxtx.poi;

import com.lxtx.pinyin.PinyinUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class CaacDemoTest {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径
        String userDir = System.getProperty("user.dir");
        String path = "D:\\adcc\\CAAC新增账号.xlsx";

        try {
            File file =new File(path);
            if(file.exists()){
                System.out.println("asasas");
            }
//            InputStream inputStream = FileUtil.getResourcesFileInputStream(path);
            InputStream is = new FileInputStream(path);
            InputStream inputStream = new BufferedInputStream(is);
            XSSFWorkbook xworkBook = new XSSFWorkbook(inputStream);
            XSSFSheet xssfSheet = xworkBook.getSheetAt(1);
            OutputStream outputStream = new FileOutputStream(path);
            System.out.println(xssfSheet.getLastRowNum());
            for (int i = 1; i < xssfSheet.getLastRowNum()+1; i++) {
                Row row = xssfSheet.getRow(i);
                String name = row.getCell(3).toString();
                System.out.println(name);
                // 根据汉字转拼音
                String pinyin = PinyinUtil.ToPinyin(name);
                String acount  = pinyin+"_";
                row.getCell(6).setCellValue(acount);
                row.getCell(7).setCellValue("v2fdgCV+WN77P3BHxrm8R4ToaYi8aBcybaCAt45h+pjJPDzaOCLjDGYn1vHRn0IIIUAr7Z7QMhCWC7Sp+FehqQ==");
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
