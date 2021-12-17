package com.lxtx.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * @author Eternity
 * @version 1.0
 * @description 布隆过滤器 数据无法删除
 * @date 2020/9/3
 **/
public class BloomFilterTest {
    public static void main(String[] args) {
        BloomFilter bf =BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")),10000,0.00001);
//        bf.put(1001);
//        boolean s = bf.mightContain(1001);
        // 一开始要进行数据全量加载
        for (int i = 0; i < 100000; i++) {
            bf.put(String.valueOf(i));
        }
        int count=0;
        // 后续才能判断是否存在
        for (int i = 0; i < 1000; i++) {
            boolean isExist =bf.mightContain("immoc"+i);
//            System.out.println(i+":"+isExist);
            if(!isExist){
                count++;
            }
        }
        System.out.println("误判率："+count);
    }
}
