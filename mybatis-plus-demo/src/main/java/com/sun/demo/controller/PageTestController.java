package com.sun.demo.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.demo.entity.User;
import com.sun.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author jackson
 * @version 1.0
 * @description
 * @date 2021/9/22
 **/
@Controller
@RequestMapping(value="/pagetest", method= {RequestMethod.POST, RequestMethod.GET})
public class PageTestController {

    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @RequestMapping(value="/test1", method= {RequestMethod.POST, RequestMethod.GET})
    public String test1() {
        PageInfo<User> info = PageHelper.startPage(2, 2).doSelectPageInfo(()->userMapper.selectList());
        return JSON.toJSONString(info);
    }

    @ResponseBody
    @RequestMapping(value="/test2", method= {RequestMethod.POST, RequestMethod.GET})
    public List<User> test2() {
        List<User> users = userMapper.selectList();
        return users;
    }
}
