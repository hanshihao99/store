package com.cy.store_.service;

import com.cy.store_.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cy.store_.mapper.TOrderMapper;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @author hanshihao
* @description 针对表【t_order】的数据库操作Service
* @createDate 2023-10-15 20:02:25
*/
public interface OrderService extends IService<Order> {

    Order createOrder(Integer aid,Integer uid,String username,Integer[] cids);

}
