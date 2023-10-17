package com.cy.store_.service;

import com.cy.store_.entity.Cart;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cy.store_.modle.CartVo;

import java.util.List;

/**
* @author hanshihao
* @description 针对表【t_cart】的数据库操作Service
* @createDate 2023-10-14 22:40:15
*/
public interface CartService extends IService<Cart> {

    void updateCart(Integer uid,Integer pid,Integer num,String username);

    List<CartVo> getVOByUid(Integer uid);

    Integer addNum(Integer cid,Integer uid,String username);

    /**
     * 获取购物车中勾选的商品
     * @param uid 用户id
     * @param cids 购物车中勾选的商品id
     * @return 返回勾选中的商品
     */
    List<CartVo> getVOByCid(Integer uid,Integer[] cids);

    List<CartVo> getVOByCidTest(Integer uid,List<Integer> cids);

}
