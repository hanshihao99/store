package com.cy.store_.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.store_.entity.Cart;
import com.cy.store_.entity.Product;
import com.cy.store_.mapper.TProductMapper;
import com.cy.store_.modle.CartVo;
import com.cy.store_.service.CartService;
import com.cy.store_.mapper.TCartMapper;
import com.cy.store_.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

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

    @Override
    public List<CartVo> getVOByUid(Integer uid) {
        List<CartVo> listResult = tCartMapper.getVOByUid(uid);
        if(listResult == null){
            throw new CartNotFountException("购物车商品不存在");
        }
        return listResult;
    }

    @Override
    public Integer addNum(Integer cid,Integer uid,String username) {
        Cart cart = tCartMapper.findByCid(cid);
        if(cart == null){
            throw new CartNotFountException("购物车商品不存在");
        }
        if(!cart.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        Integer num = cart.getNum() + 1;
        int rows = tCartMapper.updateNumByProduct(num, cid, username);
        if(rows != 1){
            throw new UpdateException("更新时异常");
        }
        return num;
    }

    @Override
    public List<CartVo> getVOByCid(Integer uid,Integer[] cids) {
        List<CartVo> list = tCartMapper.getVOByCid(cids);
        if(list == null){
            throw new CartNotFountException("购物车商品不存在");
        }
        Iterator<CartVo> iterator = list.iterator();
        while(iterator.hasNext()){
            CartVo cartVo = iterator.next();
            if(!cartVo.getUid().equals(uid)){ // 说明当前购物车数据不属于该用户
                throw new AccessDeniedException("非法数据访问");
                // 或者执行迭代器的remove方法，将list中数据删掉
                //iterator.remove();
            }
        }
        return list;
    }

    @Override
    public List<CartVo> getVOByCidTest(Integer uid, List<Integer> cids) {
        List<CartVo> list = tCartMapper.getVOByCidTest(cids);
        if(list == null){
            throw new CartNotFountException("购物车商品不存在");
        }
        Iterator<CartVo> iterator = list.iterator();
        while(iterator.hasNext()){
            CartVo cartVo = iterator.next();
            if(!cartVo.getUid().equals(uid)){ // 说明当前购物车数据不属于该用户
                throw new AccessDeniedException("非法数据访问");
                // 或者执行迭代器的remove方法，将list中数据删掉
                //iterator.remove();
            }
        }
        return list;
    }
}




