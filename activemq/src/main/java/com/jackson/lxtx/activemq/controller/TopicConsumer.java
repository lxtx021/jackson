package com.jackson.lxtx.activemq.controller;

//@Component
public class TopicConsumer {

    /**
     * 监听消息,名字为生产者发送的名字,要一致,不然监听不到.
     * 因为是订阅者模式,可以有多个消费者,我们这里举两个来进行测试
     * @param string
     */
    /*@JmsListener(destination = "${topic}")
    public void consumerTopicOne(String string){

        System.out.println("我是消费者一号:消费消息成功,信息为---> "+string);

    }

    @JmsListener(destination = "${topic}")
    public void consumerTopicTwo(String string){

        System.out.println("我是消费者二号:消费消息成功,信息为---> "+string);

    }*/
}
