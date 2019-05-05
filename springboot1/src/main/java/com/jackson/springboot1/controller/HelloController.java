package com.jackson.springboot1.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sun
 */
@RestController
public class HelloController {
    @ApiOperation(value = "测试接口hello")
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }}
