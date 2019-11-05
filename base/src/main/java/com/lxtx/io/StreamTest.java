package com.lxtx.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class StreamTest {
    public static void main(String[] args) throws IOException {
        String content="nihao,这是 Blocking I/O";
        byte[] inputBytes = content.getBytes(Charset.forName("utf-8"));
        // 将字节数组转成字节输入流
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        // 将字节输入流数据写入字节输出流 ByteArrayOutputStream
        byte[] bytes = new byte[1024];
        int size =0;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while ((size =inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,size);
        }
        // 将字节输出流打印到控制台
        System.out.println(outputStream.toString("utf-8"));
    }
}
