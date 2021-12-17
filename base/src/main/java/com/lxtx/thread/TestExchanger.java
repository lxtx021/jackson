package com.lxtx.thread;

import java.util.concurrent.Exchanger;

/**
 * @author 孙洪波
 * @version 1.0
 * @description Exchanger
 * Exchanger提供了让两个线程互相交换数据的同步点。Exchanger有点像2个线程的CyclicBarrier，线程之间都是互相等待，区别在于Exchanger多了交换的操作。
 * 举个例子好比以前玩网游的时候，买家和卖家必须走到地图上同一地点面对面进行交易一样，一手交钱一手交装备。
 * @date 2021/6/9
 **/
public class TestExchanger {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String weapon = "装备";
                System.out.println("我是卖家，我带着" + weapon + "过来了！");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("卖家到达地图上交易地点");
                try {
                    System.out.println("我是卖家，换回了" + exchanger.exchange(weapon));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                String money = "一万游戏币";
                System.out.println("我是买家，我带着" + money + "过来了");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("买家到达地图上交易地点");
                try {
                    System.out.println("我是买家，换回了" + exchanger.exchange(money));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
