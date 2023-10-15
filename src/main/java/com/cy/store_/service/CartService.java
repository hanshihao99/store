package com.cy.store_.service;

import com.cy.store_.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author hanshihao
* @description 针对表【t_cart】的数据库操作Service
* @createDate 2023-10-14 22:40:15
*/
public interface CartService extends IService<Cart> {

    void updateCart(Integer uid,Integer pid,Integer num,String username);

}
