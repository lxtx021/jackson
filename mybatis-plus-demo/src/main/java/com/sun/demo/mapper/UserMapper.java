package com.sun.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.demo.entity.User;

import java.util.List;

/**
 * @author 孙洪波
 * @version 1.0
 * @description
 * @date 2021/9/9
 **/
public interface UserMapper extends BaseMapper<User> {

    List<User> selectList();
}
