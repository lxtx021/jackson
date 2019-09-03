package com.adcc.hkp.rabbit.mq;

import java.io.IOException;

import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

public class RabbitMQReciver {
	Connection connection = null;
	Channel channel = null;

	public void open() {
		try {
			ConnectionFactory factory = new ConnectionFactory();
			Address[] addre = new Address[] {
					new Address(RabbitMQConfig.IP1, RabbitMQConfig.ClientPort),
					new Address(RabbitMQConfig.IP2, RabbitMQConfig.ClientPort)  };
			factory.setUsername(RabbitMQConfig.UserName);// MQ用户名
			factory.setPassword(RabbitMQConfig.Password);// MQ密码
			factory.setAutomaticRecoveryEnabled(true);// 自动重连
			factory.setVirtualHost(RabbitMQConfig.Vhost);
			connection = factory.newConnection(addre);
			channel = connection.createChannel();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 开始接收信息，自动回执
	 * 
	 * @param queueName
	 * @param reciver
	 */
	public void startReciver(String queueName, String routeKey,
			final IReciverMessage reciver) {
		try {
			channel.basicQos(Integer.MAX_VALUE);

			/* 创建消费者对象，用于读取消息 */
			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag,
						Envelope envelope, BasicProperties properties,
						byte[] body) throws IOException {
					super.handleDelivery(consumerTag, envelope, properties,
							body);
					//String message = new String(body);
					if (reciver != null) {
						reciver.reciver(body);
					}
				}
			};
			channel.queueDeclare(queueName, false, false, true, null);
			channel.exchangeBind(RabbitMQConfig.ExChange, queueName, routeKey);
			channel.basicConsume(queueName, true, consumer);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 开始接收信息，自动回执
	 * 
	 * @param queueName
	 * @param reciver
	 */
	public void startReciver(String queueName, final IReciverMessage reciver) {
		try {
			channel.basicQos(Integer.MAX_VALUE);

			/* 创建消费者对象，用于读取消息 */
			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag,
						Envelope envelope, BasicProperties properties,
						byte[] body) throws IOException {
					super.handleDelivery(consumerTag, envelope, properties,
							body);
					//String message = new String(body);
					if (reciver != null) {
						reciver.reciver(body);
					}
				}
			};
			channel.basicConsume(queueName, true, consumer);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 开始接收信息， 逐条接收手动回执
	 * 
	 * @param queueName
	 * @param reciver
	 */
	public void startReciverSingle(String queueName, final IReciverMessage reciver) {
		try {
			/* 创建消费者对象，用于读取消息 */
			channel.basicQos(1);

			/* 创建消费者对象，用于读取消息 */
			Consumer consumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag,
						Envelope envelope, BasicProperties properties,
						byte[] body) throws IOException {
					super.handleDelivery(consumerTag, envelope, properties,
							body);
					//String message = new String(body);
					try {
						if (reciver != null) {
							reciver.reciver(body);
						}
						channel.basicAck(envelope.getDeliveryTag(), true);
					} catch (Exception e) {
						channel.basicAck(envelope.getDeliveryTag(), false);
					}
				}
			};
			channel.basicConsume(queueName, false, consumer);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			channel.close();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
