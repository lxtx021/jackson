package com.jackson.lxtx.service.impl;

import com.jackson.lxtx.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

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

    @Override
    public String test1() {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
//        String str = operations.get("2019050100009976:7815C3:CCA4519:standHeight");
//        System.out.println("str:"+str);
//        /** 根据正则获取当天的所有key值*/
//        Set<String> keys =redisTemplate.keys( "201905090000*");
//        System.out.println(keys.size());
        Long num  = redisTemplate.opsForValue().increment("2019",1);
        System.out.println(num);
        String str = String.format("%04d", num);

        System.out.println(str);

//        HashSet<String> keySet = new HashSet<String>();
/*
        for (String accurateKey : keys) {

            *//**获取最后一个冒号的索引*//*
            int index = accurateKey.lastIndexOf(":");
            String keyTemp = accurateKey.substring(0,index);

            *//**把KEY值放入HASHSET中去重*//*
            keySet.add(keyTemp);
        }*/
//        20190501 0000 0007
        return str;
    }

    /**计算当天时间*//*
    long current = System.currentTimeMillis();//当前时间毫秒数
    long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
    long mill = (current - zero) * 10;

    *//**判断当天日期，（UTC与北京时间不在一天）*//*
    if ((mill - 8 * 3600 * 1000) < 0) {
        currentDate = preDate;
    } else {
        currentDate = curDate;
    }

    *//**进行时间值判断，得到时间值*//*
    String mills = ((null != resultMap.get("TAP")) ? resultMap.get("TAP") : resultMap.get("TRP")).toString();
    String ModeC = (null != resultMap.get("ADDR") ? resultMap.get("ADDR").toString() : "");
    String FlNo = (null != resultMap.get("CS") ? resultMap.get("CS").toString() : "");

    //设置保存redis的基本key
    StringBuffer key = new StringBuffer();
    key.append(currentDate + mill + ":" + ModeC + ":" + FlNo + ":");*/
    public static void main(String[] args) {
        /**计算当天时间*/
        long current = System.currentTimeMillis();//当前时间毫秒数
        long rowOffset = TimeZone.getDefault().getRawOffset();
        System.out.println("rowOffset:"+rowOffset);
        long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long mill = (current - zero) * 10;
        System.out.println(mill);
    }

//    long current=System.currentTimeMillis();//当前时间毫秒数
//    long zero=current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
//    long twelve=zero+24*60*60*1000-1;//今天23点59分59秒的毫秒数
//    long yesterday=System.currentTimeMillis()-24*60*60*1000;//昨天的这一时间的毫秒数
//    System.out.println(new Timestamp(current));//当前时间
//    System.out.println(new Timestamp(yesterday));//昨天这一时间点
//    System.out.println(new Timestamp(zero));//今天零点零分零秒
//    System.out.println(new Timestamp(twelve));//今天23点59分59秒

    public List<Object> batchGet(List<String> keys){
        List<Object> result= redisTemplate.executePipelined(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection src =(StringRedisConnection)connection;
                src.get("12");
                src.set("12","12");
                for (String key :keys) {
                    src.get(key);
                }
                return null;
            }
        });
        return result;
    }
}
