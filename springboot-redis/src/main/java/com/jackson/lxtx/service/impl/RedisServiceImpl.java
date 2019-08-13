package com.jackson.lxtx.service.impl;

import com.jackson.lxtx.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void setString(){
        redisTemplate.opsForValue().set("name","nasus");
        redisTemplate.opsForValue().set("age",24);
        redisTemplate.opsForValue().set("city","清远");
    }

    @Override
    public String getString(){
        String name = (String) redisTemplate.opsForValue().get("name");
        int age = (Integer) redisTemplate.opsForValue().get("age");
        String city = (String) redisTemplate.opsForValue().get("city");
        String result  = "name:"+name+",age:"+age+",city:"+city;
        return result;
    }

}
