package com.lxtx.redis;

import org.redisson.config.Config;
import org.redisson.config.TransportMode;

/**
 * @author jackson
 */
public class RedissonTest {
    public static void main(String[] args) {
        Config config = new Config();
        //可以用"rediss://"来启用SSL连接
        config.setTransportMode(TransportMode.EPOLL);
        config.useClusterServers().addNodeAddress("redis://127.0.0.1:7181");
    }
}
