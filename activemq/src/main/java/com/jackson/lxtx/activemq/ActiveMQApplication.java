package com.jackson.lxtx.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author 孙洪波
 * @version 1.0
 * @description
 * @date 2022/4/18
 **/
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableJms
public class ActiveMQApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActiveMQApplication.class, args);
    }
}
