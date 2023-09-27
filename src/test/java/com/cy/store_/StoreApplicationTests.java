package com.cy.store_;

import com.cy.store_.mapper.TUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StoreApplicationTests {


    @Autowired
    private TUserMapper userMapper;


    @Test
    void contextLoads() {

    }



}
