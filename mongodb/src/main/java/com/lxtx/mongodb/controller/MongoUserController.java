package com.lxtx.mongodb.controller;

import com.lxtx.mongodb.base.Result;
import com.lxtx.mongodb.base.CodeConst;
import com.lxtx.mongodb.model.MongoUser;
import com.lxtx.mongodb.service.MongoUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mongodb")
@Api("mongodb测试")
public class MongoUserController {

    private final MongoUserService service;

    @Autowired
    public MongoUserController(MongoUserService service) {
        this.service = service;
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Result get(@PathVariable("id") Long id) {
        MongoUser mongoUser = service.findById(id);
        return new Result<>(mongoUser);
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Result findAll() {
        return new Result<>(service.findAll());
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result add(@RequestBody MongoUser user) {
        return new Result<>(service.add(user));
    }

    @RequestMapping(value = "mutiadd", method = RequestMethod.POST)
    public Result mutiadd() {
        return new Result<>(service.mutiadd());
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public Result delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new Result(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage());
    }

}
