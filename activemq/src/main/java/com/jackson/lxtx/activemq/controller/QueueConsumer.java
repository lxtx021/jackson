package com.jackson.lxtx.activemq.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    /**
     * 监听消息,名字为生产者发送的名字,要一致,不然监听不到.
     * 因为是队列模式,只能消费者
     * @param bytes
     */
    /*@JmsListener(destination = "${queue}")
    public void consumerQueue(byte[] bytes){
        String json = new String(bytes);
        System.out.println("消费消息成功,信息为---> "+new String(bytes));
    }*/


    private int num=0;

    private long total = 0;
    /**
     * 监听消息,名字为生产者发送的名字,要一致,不然监听不到.
     * 因为是队列模式,只能消费者
     * @param bytes
     */
    @JmsListener(destination = "${queue}", containerFactory = "jmsQueue2Listener")
    public void consumerQueue(byte[] bytes){
        String json = new String(bytes);
        total++;

        if(total%1000==1){
            System.out.println("当前接受的MQ数据总量："+total);
            System.out.println("当前时间为："+System.currentTimeMillis());
        }
    }


}
