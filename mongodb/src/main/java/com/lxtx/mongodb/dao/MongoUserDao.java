package com.lxtx.mongodb.dao;

import com.lxtx.mongodb.model.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoUserDao extends MongoRepository<MongoUser, Long> {

    /**
     * 根据字字查用户
     *
     * @param userName
     * @return
     */
    MongoUser findByUserName(String userName);

}
