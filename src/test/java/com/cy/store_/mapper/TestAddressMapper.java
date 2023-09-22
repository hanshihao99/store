package com.cy.store_.mapper;

import com.cy.store_.entity.Address;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/09/09/18:48
 */

// @SpringBootTest 表示当前是一个测试类，不会随同项目一起打包
@SpringBootTest
// @RunWith 表示启动这个单元测试类 ，当前这个注解运行会有报错提示
@RunWith(SpringRunner.class)
public class TestAddressMapper {

    @Autowired
    private TAddressMapper addressMapper;

    @Test
    public void insert (){
        Address address = new Address();
        address.setUid(15);
        address.setPhone("4321555");
        address.setName("王小虎");

        addressMapper.insert(address);

    }
    @Test
    public void select (){
        int i = addressMapper.countByUid(15);
        System.out.println(i);
    }


}
