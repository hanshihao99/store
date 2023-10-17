package com.cy.store_.mapper;

import com.cy.store_.entity.Cart;
import com.cy.store_.entity.DictDistrict;
import com.cy.store_.modle.CartVo;
import org.checkerframework.checker.units.qual.C;
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
 * @Date: 2023/10/14/23:19
 */
@SpringBootTest
// @RunWith 表示启动这个单元测试类 ，当前这个注解运行会有报错提示
@RunWith(SpringRunner.class)
public class CartMapperTest {

    @Autowired
    TCartMapper tCartMapper;

    @Test
    public void insert () {
        Cart cart = new Cart();
        cart.setNum(2);
        cart.setPid(10000001);
        cart.setUid(15);
        cart.setPrice(18L);
        cart.setCreatedTime(new Date());
        cart.setCreatedTime(new Date());
        cart.setCreatedUser("jerry");
        cart.setModifiedUser("jerry");
        int row = tCartMapper.insert(cart);
        System.out.println(row);
    }

    @Test
    public void find () {
        Cart cart = tCartMapper.searchByProduct(15, 10000001);
        System.out.println(cart);
    }

    @Test
    public void findByUid () {
        List<CartVo> byUid = tCartMapper.getVOByUid(15);
        System.out.println(byUid);
    }

    @Test
    public void findByCid () {
        Integer[] cids = new Integer[]{1,2};
        List<CartVo> voByCid = tCartMapper.getVOByCid(cids);
        System.out.println(voByCid);
    }
}
