package com.jackson.lxtx.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

@RestController
public class ProducerController {

    /*@Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    *//**
     * 点对点的消息队列的生产者
     * @param string
     *//*
    @GetMapping("/queue")
    public void sendMsgQueue(@RequestParam String string){
        System.out.println("消息已经发送,准备被消费,消息为 ---> "+string);
        jmsMessagingTemplate.convertAndSend(queue,string);
    }

    *//**
     * 一对多的消息队列的生产者
     * @param string
     *//*
    @GetMapping("/topic")
    public void sendMsgTopic(@RequestParam String string){
        System.out.println("消息已经发送,准备被消费,消息为 ---> "+string);
        jmsMessagingTemplate.convertAndSend(topic,string);
    }*/

}
