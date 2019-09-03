package com.adcc.hkp.rabbit.mq;

import java.util.ArrayList;
import java.util.List;

import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQSend {
	Connection connection = null;
//	Channel channel = null;
	List<Channel> allChannel = new ArrayList<Channel>();
	int maxChannelSize = 5;

	public void open() throws Exception {
		try {
			ConnectionFactory factory = new ConnectionFactory();
			Address[] addre = new Address[] {
					new Address(RabbitMQConfig.IP1, RabbitMQConfig.ClientPort),
					new Address(RabbitMQConfig.IP2, RabbitMQConfig.ClientPort) };
			factory.setUsername(RabbitMQConfig.UserName);// MQ用户名
			factory.setPassword(RabbitMQConfig.Password);// MQ密码
			factory.setAutomaticRecoveryEnabled(true);// 自动重连
			factory.setVirtualHost(RabbitMQConfig.Vhost);
			
			connection = factory.newConnection(addre);
			for (int i = 0; i < maxChannelSize; i++) {
				Channel channel = connection.createChannel();
				allChannel.add(channel);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	int lastIndex = 0;
	public void sendMessage(String routeKey, String message) {
		sendMessage(routeKey,message.getBytes());
	}

	public void sendMessage(String routeKey, byte[] message) {
		try {
			Channel channel = allChannel.get(lastIndex);
			channel.basicPublish(RabbitMQConfig.ExChange, routeKey, null,
					message);

			lastIndex ++;
			if(lastIndex >= allChannel.size()){
				lastIndex = 0;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void close() throws Exception {
		try {
			for (Channel channel : allChannel) {
				channel.close();
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
	}
}
