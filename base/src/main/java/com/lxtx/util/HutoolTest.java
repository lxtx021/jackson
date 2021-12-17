package com.lxtx.util;

import cn.hutool.core.util.StrUtil;

/**
 * @author 孙洪波
 * @version 1.0
 * @description
 * @date 2021/7/12
 **/
public class HutoolTest {
    public static void main(String[] args) {
        String str = "LCST000000009003";
        String[] arr =StrUtil.split(str,15);
        int num = Integer.parseInt(arr[1])-1;
        String lifeState = arr[0]+num;
        System.out.println(str);
        System.out.println(lifeState);
        System.out.println(num);
        System.out.println(str.length());
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
