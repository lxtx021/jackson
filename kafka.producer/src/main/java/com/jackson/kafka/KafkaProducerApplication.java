package com.jackson.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author jackson
 */
@SpringBootApplication
public class KafkaProducerApplication {

/*
	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}
*/

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(KafkaProducerApplication.class, args);
		KafkaSender sender = context.getBean(KafkaSender.class);

		for (int i = 0; i < 1000; i++) {
			//调用消息发送类中的消息发送方法
			sender.send();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
