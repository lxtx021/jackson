package com.jackson.lxtx.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class ActiveMqConfig {
    /**
     * 对应yml文件中定义的queue
     */
    @Value("${queue}")
    private String queue;

    /**
     * 对应yml文件中定义的topic
     */
    @Value("${topic}")
    private String topic;
    /**
     * 创建点对点的队列  一个消息只能被一个消费者消费  --- 一对一
     * 声明普通队列
     * @return
     */
    @Bean
    public Queue queue(){
        return new ActiveMQQueue(queue);
    }
    /**
     * 创建订阅式的队列  一个消息可以被多个消费者消费 --- 一对多
     * 声明订阅模式-广播队列
     * @return
     */
    @Bean
    public Topic topic(){
        return new ActiveMQTopic(topic);
    }

}

