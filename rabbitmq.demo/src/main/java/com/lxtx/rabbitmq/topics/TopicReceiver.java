package com.lxtx.rabbitmq.topics;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @author jackson
 */
@Component
@RabbitListener(queues = "HKP")
public class TopicReceiver {

   public static Logger logger = Logger.getLogger(TopicReceiver.class.getName());
    @RabbitHandler
    public void process(String message) {
        System.out.println("Topic Receiver1  : " + message);
        logger.info("log msg:"+message);
    }

}
