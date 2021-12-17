package com.lxtx.base.collection;

import org.apache.commons.lang.StringUtils;

/**
 * @author 孙洪波
 * @version 1.0
 * @description
 * @date 2021/8/23
 **/
public class StringTest2 {
    public static void main(String[] args) {
        StringBuffer no =new StringBuffer("EVT-121".concat("-"));
        String lastStr = StringUtils.substring("Test-12-009",-3);
        String numStr = StringUtils.leftPad(String.valueOf(Integer.parseInt(lastStr)+1),3,"0");
        String str = no.append(numStr).toString();
        System.out.println(numStr);
        System.out.println(str);
    }
}
