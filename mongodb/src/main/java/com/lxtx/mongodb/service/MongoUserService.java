package com.lxtx.mongodb.service;


import com.lxtx.mongodb.model.MongoUser;

import java.util.List;


public interface MongoUserService {

    /**
     * 查所有
     *
     * @return
     */
    List<MongoUser> findAll();

    /**
     * 根据id查
     *
     * @param id
     * @return
     */
    MongoUser findById(Long id);

    /**
     * 根据名字查
     *
     * @param userName
     * @return
     */
    MongoUser findByName(String userName);

    /**
     * 添加
     *
     * @param mongoUser
     * @return
     */
    MongoUser add(MongoUser mongoUser);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 更新
     *
     * @param mongoUser
     * @return
     */
    MongoUser update(MongoUser mongoUser);

    int mutiadd();
}
