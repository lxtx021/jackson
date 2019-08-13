package com.jackson.springboot1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

public interface RedisService {

    public void setString();

    public String getString();

}
