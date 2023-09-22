package com.cy.store_.mapper;

import com.cy.store_.entity.User;
import org.apache.ibatis.annotations.Arg;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/09/09/18:48
 */

// @SpringBootTest 表示当前是一个测试类，不会随同项目一起打包
@SpringBootTest
// @RunWith 表示启动这个单元测试类 ，当前这个注解运行会有报错提示
@RunWith(SpringRunner.class)
public class TestMapper {

    @Autowired
    private TUserMapper userMapper;

//    @Test
//    public void insert(){
//        User user = new User();
//        user.setUsername("韩少飞");
//        user.setPassword("HelloWo");
//        Integer inset = userMapper.inset(user);
//        System.out.println(inset);
//    }

//    @Test
//    public void getName(){
//        List<User> all = userMapper.findAll();
//        System.out.println(all);
//    }

}
