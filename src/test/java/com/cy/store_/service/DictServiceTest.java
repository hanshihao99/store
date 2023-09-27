package com.cy.store_.service;

import com.cy.store_.entity.DictDistrict;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/09/23/23:21
 */

// @SpringBootTest 表示当前是一个测试类，不会随同项目一起打包
@SpringBootTest
// @RunWith 表示启动这个单元测试类 ，当前这个注解运行会有报错提示
@RunWith(SpringRunner.class)
public class DictServiceTest {

    @Autowired
    DictDistrictService dictDistrictService;
    @Test
    public void findByParent() {
        List<DictDistrict> byParent = dictDistrictService.getByParent("86");
        for(DictDistrict di : byParent){
            System.out.println(di);
        }

    }

}
