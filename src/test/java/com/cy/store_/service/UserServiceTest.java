package com.cy.store_.service;

import com.cy.store_.entity.User;
import com.cy.store_.mapper.TUserMapper;
import com.cy.store_.service.ex.ServiceException;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/09/10/00:29
 */
@SpringBootTest
public class UserServiceTest {
////
    @Autowired
    private UserService userService;

    @Autowired
    private TUserMapper userMapper;
//
//    @Test
//    public void updatePasswordByUid(){
//        userMapper.updatePasswordByUid(1,"1234561","han",new Date());
//    }
//
//    @Test
//    public void findByUid(){
//        User byUid = userMapper.findByUid(1);
//        System.out.println(byUid);
//    }
//
    @Test
    public void updatePass(){
        String a = "heool.hih";
        String substring = a.substring(a.lastIndexOf("."));
        System.out.println(a.lastIndexOf("."));
        System.out.println(substring);

    }
//
//
//    @Test
//    public void login(){
//        User test = userService.login("jerry", "jerry");
//        System.out.println(test);
//    }
//
//    @Test
//    public void reg(){
//        try {
//            User user = new User();
//            user.setUsername("jerry");
//            user.setPassword("jerry");
//            userService.reg(user);
////            System.out.println("OK");
//        }catch (ServiceException e){
//            System.out.println(e.getClass().getSimpleName());
//            System.out.println(e.getMessage());
//        }
//
//    }
}
