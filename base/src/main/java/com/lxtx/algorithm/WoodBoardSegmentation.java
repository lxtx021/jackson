package com.lxtx.algorithm;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 木板分割算法
 * @author jackson
 */
public class WoodBoardSegmentation {
    /**
     * 算法需求：
     * 根据不同的木板尺寸（长宽）
     * 固定的板材尺寸长宽（1200*2400 ）单位（mm）
     * 计算出需要多少张板材，并分别算出每张板材如何切割
     * 最优板材切割算法
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 1、计算方法注意事项：
         * 需要注意每张板材的长宽
         * 多块板（长宽）加起来，不能超过整张板材的长宽
         * 在最优计算切割整张板材数据中，要
         *
         */
        // 底
        System.out.println(Math.floor(2.6));
        // 顶
        System.out.println(Math.ceil(2.1));
        /**
         * 1、先查询出所有需要计算的木块尺寸、数量
         * 2、循环每个木块，如果有木块的长宽超出整张板的长宽任意一项，另行计算
         * 3、如果有木块长度或者宽度超过板材尺寸的一半，需要单独处理
         * 4、超出一半的话，两种情况 1、长宽都超出   2、一种超出，需要匹配最优算法 避免板材浪费
         */
        /**
         *  贪心算法：
         *  1、按照木块长宽降序排序所有的木块List
         *  2、先取得一整张板材按照长宽从最大的一块木材一张一张的匹配
         */
        List<WoodBean> data = new ArrayList<>(20);
        List<WoodBean> list = new ArrayList<>();
        int boardNum=1;
        if(CollectionUtils.isNotEmpty(data)){
            for (int i = 0; i < data.size(); i++) {

            }
        }



    }

}
