package com.lxtx.mongodb.service.impl;

import com.lxtx.mongodb.dao.MongoUserDao;
import com.lxtx.mongodb.model.MongoUser;
import com.lxtx.mongodb.service.MongoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;


@Service
public class MongoUserServiceImpl implements MongoUserService {
    private final MongoUserDao dao;

    @Autowired
    public MongoUserServiceImpl(MongoUserDao dao) {
        this.dao = dao;
    }

    @Override
    public List<MongoUser> findAll() {
        return dao.findAll();
    }

    @Override
    public MongoUser findById(Long id) {
        Optional<MongoUser> optionalUser = dao.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public MongoUser findByName(String userName) {
        return dao.findByUserName(userName);
    }

    @Override
    public MongoUser add(MongoUser mongoUser) {
        return dao.save(mongoUser);
    }

    @Override
    public void delete(Long id) {
        Optional<MongoUser> optional = dao.findById(id);
        if (!optional.isPresent()) {
            return;
        }
        dao.delete(optional.get());
    }

    @Override
    public MongoUser update(MongoUser mongoUser) {
        return dao.save(mongoUser);
    }

    @Override
    public int mutiadd() {
        List<MongoUser> list =new ArrayList<>(10000);

        Long a =Calendar.getInstance().getTimeInMillis();
        System.out.println("数据组织时间 start:"+a);
        for (int i = 20000; i <= 99999; i++) {
            MongoUser user =new MongoUser();
            user.setId(i);
            user.setEmail("email"+i);
            user.setUserName("userName"+i);
            user.setPassword("password"+i);
            user.setSalt("salt");
            user.setValidateCode("ValidateCode"+i);
            user.setGender(i%2);
            user.setPhone(Integer.toUnsignedLong(100000+i));
            user.setImgUrl("imgUrl"+i);
            user.setAddress("address"+i);
            user.setRegisterTime(Calendar.getInstance().getTimeInMillis());
            list.add(user);
        }
        Long b = Calendar.getInstance().getTimeInMillis();
        System.out.println("数据组织时间 end:"+Calendar.getInstance().getTimeInMillis());
        System.out.println("数据组织时间:"+((b-a)/1000));
        Long c = Calendar.getInstance().getTimeInMillis();
        System.out.println("插入时间 start:"+Calendar.getInstance().getTimeInMillis());
        List<MongoUser> res =  dao.insert(list);
        Long d = Calendar.getInstance().getTimeInMillis();
        System.out.println("插入时间 end:"+Calendar.getInstance().getTimeInMillis());
        System.out.println("插入时间:"+((d-c)/1000));
        return res.size();
    }
}
