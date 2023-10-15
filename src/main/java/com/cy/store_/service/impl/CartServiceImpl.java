package com.cy.store_.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.store_.entity.Cart;
import com.cy.store_.entity.Product;
import com.cy.store_.mapper.TProductMapper;
import com.cy.store_.service.CartService;
import com.cy.store_.mapper.TCartMapper;
import com.cy.store_.service.ex.InsertException;
import com.cy.store_.service.ex.ProductNotFoundException;
import com.cy.store_.service.ex.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author hanshihao
* @description 针对表【t_cart】的数据库操作Service实现
* @createDate 2023-10-14 22:40:15
*/
@Service
public class CartServiceImpl extends ServiceImpl<TCartMapper, Cart>
    implements CartService {

    @Autowired
    TCartMapper tCartMapper;
    @Autowired
    TProductMapper tProductMapper;


    @Override
    public void updateCart(Integer uid, Integer pid, Integer num, String username) {
        Cart result = tCartMapper.searchByProduct(uid, pid);
        Product product = tProductMapper.findByid(pid);
        if(product == null){
            throw new ProductNotFoundException("当前商品不存在");

        }
        if (result == null) { // 说明数据库没数据，执行插入操作
            Cart cart = new Cart();
            cart.setPid(pid);
            cart.setUid(uid);
            cart.setPrice(product.getPrice());
            cart.setNum(num);
            cart.setCreatedUser(username);
            cart.setModifiedTime(new Date());
            cart.setCreatedTime(new Date());
            cart.setModifiedUser(username);
            int rows = tCartMapper.insert(cart);
            if (rows != 1) {
                throw new InsertException("插入数据时发生异常");
            }
        } else {
            int rows = tCartMapper.updateNumByProduct(result.getNum() + num, result.getCid(), username);
            if (rows != 1) {
                throw new UpdateException("更新数据时发生异常");
            }
        }
    }
}




