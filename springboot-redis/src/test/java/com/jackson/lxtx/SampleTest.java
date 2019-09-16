package com.jackson.lxtx;

import com.jackson.lxtx.service.RedisTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>
 * 内置 CRUD 演示
 * </p>
 *
 * @author hubin
 * @since 2018-08-11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    private RedisTestService redisTestService;
    /*@Test
    public void test1(){
        redisTestService.test1();
    }*/

    @Test
    public void test2(){
        redisTestService.test2();
    }

}
