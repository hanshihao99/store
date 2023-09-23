package com.cy.store_.service;

import com.cy.store_.entity.Address;
import com.cy.store_.service.ex.AddressCountLimitException;
import com.cy.store_.service.ex.InsertException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/09/23/23:21
 */

// @SpringBootTest 表示当前是一个测试类，不会随同项目一起打包
@SpringBootTest
// @RunWith 表示启动这个单元测试类 ，当前这个注解运行会有报错提示
@RunWith(SpringRunner.class)
public class AddressServiceTest {

    @Autowired
    AddressService addressService;
    @Test
    public void addnewAddress() {
        Address address = new Address();
        address.setName("韩少飞");
        address.setAddress("坡头村大槐树健身广场");
        address.setPhone("1527578678");
        address.setCityCode("047100");
        addressService.addnewAddress(11,"韩少飞",address);
    }

}
