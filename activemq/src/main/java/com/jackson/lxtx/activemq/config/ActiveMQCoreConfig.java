package com.jackson.lxtx.activemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Session;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 孙洪波
 * @version 1.0
 * @description 消息队列核心配置
 * @date 2022/4/21
 **/
@EnableJms
@Configuration
public class ActiveMQCoreConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Value("${spring.activemq.user}")
    private String username;

    @Value("${spring.activemq.password}")
    private String password;

    /**
     * 消息重发策略配置
     */
    @Bean
    public RedeliveryPolicy redeliveryPolicy() {
        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
        //是否在每次尝试重新发送失败后,增长这个等待时间
        redeliveryPolicy.setUseExponentialBackOff(true);
        //重发次数,默认为6次-设置为10次
        redeliveryPolicy.setMaximumRedeliveries(10);
        //重发时间间隔单位毫秒,默认为1秒
        redeliveryPolicy.setInitialRedeliveryDelay(1000L);
        //第一次失败后重新发送之前等待500毫秒,第二次失败再等待500 * 2毫秒
        redeliveryPolicy.setBackOffMultiplier(2);
        //是否避免消息碰撞
        redeliveryPolicy.setUseCollisionAvoidance(false);
        //设置重发最大拖延时间-1
        redeliveryPolicy.setMaximumRedeliveryDelay(-1);
        return redeliveryPolicy;
    }

    /**
     * 消息工厂配置
     *
     * @param redeliveryPolicy
     */
    @Bean
    public ActiveMQConnectionFactory activeMqConnectionFactory(@Qualifier("redeliveryPolicy") RedeliveryPolicy redeliveryPolicy) {
        ActiveMQConnectionFactory activeMqConnectionFactory = new ActiveMQConnectionFactory(username, password, brokerUrl);
        activeMqConnectionFactory.setRedeliveryPolicy(redeliveryPolicy);
        return activeMqConnectionFactory;
    }


    @Bean(name = "jmsTemplate")
    public JmsTemplate jmsTemplate(@Qualifier("activeMqConnectionFactory") ActiveMQConnectionFactory activeMqConnectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(activeMqConnectionFactory);
        //进行持久化配置 1表示非持久化，2表示持久化
        jmsTemplate.setDeliveryMode(2);
        //客户端签收模式
        jmsTemplate.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
        return jmsTemplate;
    }

    /**
     * 默认只配置queue类型消息，
     * 如果要使用topic类型的消息，则需要配置该bean
     *
     * @return
     */
    @Bean(name = "jmsTopicListener")
    public JmsListenerContainerFactory<?> jmsTopicListener(@Qualifier("activeMqConnectionFactory") ActiveMQConnectionFactory activeMqConnectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(activeMqConnectionFactory);
        //这里必须设置为true，false则表示是queue类型
        factory.setPubSubDomain(true);
        //重连间隔时间
        factory.setRecoveryInterval(1000L);
        return factory;
    }

    /**
     * 普通队列消息监听
     *
     * @param activeMqConnectionFactory
     * @return
     */
    @Bean(name = "jmsQueue2Listener")
    public JmsListenerContainerFactory<?> jmsQueue2Listener(@Qualifier("activeMqConnectionFactory") ActiveMQConnectionFactory activeMqConnectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setPubSubDomain(false);
        factory.setConnectionFactory(activeMqConnectionFactory);
        //重连间隔时间
        factory.setRecoveryInterval(1000L);
        factory.setSessionAcknowledgeMode(1);
        //连接数
        factory.setConcurrency("10-50");
        //指定任务线程池
        factory.setTaskExecutor(new ThreadPoolExecutor(10, 100, 1, TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(100), new ThreadPoolExecutor.CallerRunsPolicy()));
        return factory;
    }
}
