package com.cy.store_.service;

import com.cy.store_.entity.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/15/22:30
 */
@SpringBootTest
// @RunWith 表示启动这个单元测试类 ，当前这个注解运行会有报错提示
@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    public void createOrder(){
        Integer[] cids = {1,2};
        Order order = orderService.createOrder(12, 15, "jerry", cids);
        System.out.println(order);

    }
}
