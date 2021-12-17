package com.lxtx.util;

/**
 * @author 孙洪波
 * @version 1.0
 * @description
 * @date 2021/7/22
 **/
public class IntegerTest {
    public static void main(String[] args) {
        Integer exeType=null;

        if(null!=exeType){
            switch (exeType){
                case 1:
                    System.out.println(1);
                    break;
                case 2:
                    System.out.println(2);
                    break;
                case 3:
                    System.out.println(3);
                    break;
                default:
                    System.out.println(0);
                    break;
            }
        }else{
            System.out.println("null");
        }

    }
}
