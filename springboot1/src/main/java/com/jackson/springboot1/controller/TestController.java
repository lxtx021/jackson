package com.jackson.springboot1.controller;

import com.alibaba.fastjson.JSONObject;
import com.jackson.springboot1.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
@RestController
public class TestController {

    @ApiOperation(value = "test3 ")
    @RequestMapping("/test3")
    public String test3(User user, HttpServletRequest request)throws Exception {
        //从Request中获取所有的参数key 和 value
        Map<String, String[]> parameterMap = request.getParameterMap();
        Iterator<Map.Entry<String, String[]>> iterator = parameterMap.entrySet().iterator();
        //获取目标类的对象
        // java 反射获取object对象的属性
        Object target = user.getClass().newInstance();
        Field[] fields = target.getClass().getDeclaredFields();
        while (iterator.hasNext()){
            Map.Entry<String, String[]> next = iterator.next();
            String key = next.getKey();
            String value = next.getValue()[0];
            for (Field field:fields){
                String name = field.getName();
                if (key.equals(name)){
                    field.setAccessible(true);
                    field.set(target,value);
                    break;
                }
            }
        }
        System.out.println("userInfo:{}"+JSONObject.toJSONString(target));
        return "Python";
    }
}
