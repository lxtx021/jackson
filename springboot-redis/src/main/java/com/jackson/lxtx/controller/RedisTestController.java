package com.jackson.lxtx.controller;

import com.jackson.lxtx.service.RedisService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sun
 */
@RestController
public class RedisTestController {

    @Autowired
    RedisService redisService;


    @ApiOperation(value = "redis 测试接口 get")
    @RequestMapping("/getredis")
    public String getRedis(){
        String result=redisService.getString();
        return result;
    }

    @ApiOperation(value = "redis 测试接口 set")
    @RequestMapping("/setredis")
    public void setRedis(){
        redisService.setString();
    }


    @ApiOperation(value = "redis 测试object set")
    @RequestMapping("/redistest1")
    public void test(){
        redisService.test1();
    }


    /**
     * 添加、获取LIST
     */
   /* @Test
    public void setList(){
        List<Student> students = studentService.findStudentList();
        log.info("students size = {}", students.size());
        //循环向 studentList 左添加值
        students.forEach(value->redisTemplate.opsForList().leftPush(LISTKEY,value));
        //向 studentList 右添加值
        Student student = new Student();
        student.setId(10);
        student.setAge(24);
        student.setName("rightPush");
        redisTemplate.opsForList().rightPush(LISTKEY,student);
        // 获取值
        log.info("studentList->{}",redisTemplate.opsForList().range(LISTKEY,0,10));
    }*/
}
