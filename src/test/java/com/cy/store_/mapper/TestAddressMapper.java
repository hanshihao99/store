package com.cy.store_.mapper;

import com.cy.store_.entity.Address;
import com.cy.store_.service.ex.AddressCountLimitException;
import com.cy.store_.service.ex.InsertException;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
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
public class TestAddressMapper {

    @Autowired
    private TAddressMapper addressMapper;

    @Test
    public void insert (){
        Address address = new Address();
        address.setUid(17);
        address.setPhone("4321555");
        address.setName("王小虎");

        addressMapper.insert(address);

    }
    @Test
    public void select (){
        int i = addressMapper.countByUid(15);
        System.out.println(i);
    }

    @Test
    public void findByUid (){
        List<Address> byUid = addressMapper.findByUid(11);
        System.out.println(byUid);
    }

    @Test
    public void findAid (){
        Address byAid = addressMapper.findAid(2);
        System.out.println(byAid);
    }

    @Test
    public void updateNonDefault (){
        Integer integer = addressMapper.updateNonDefault(15);
    }

    @Test
    public void updateDefaultByAid (){
        addressMapper.updateDefaultByAid(11,"hip");
    }



}
