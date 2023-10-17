package com.cy.store_.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.store_.entity.Address;
import com.cy.store_.entity.Order;
import com.cy.store_.entity.OrderItem;
import com.cy.store_.mapper.TOrderItemMapper;
import com.cy.store_.modle.CartVo;
import com.cy.store_.service.AddressService;
import com.cy.store_.service.CartService;
import com.cy.store_.service.OrderService;
import com.cy.store_.mapper.TOrderMapper;
import com.cy.store_.service.ex.InsertException;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author hanshihao
* @description 针对表【t_order】的数据库操作Service实现
* @createDate 2023-10-15 20:02:25
*/
@Service
public class OrderServiceImpl extends ServiceImpl<TOrderMapper, Order>
    implements OrderService {

    @Autowired
    TOrderMapper tOrderMapper;
    @Autowired
    TOrderItemMapper tOrderItemMapper;
    @Autowired
    AddressService addressService;
    @Autowired
    CartService cartService;

    @Override
    public Order createOrder(Integer aid, Integer uid, String username, Integer[] cids) {
        // 获取购物车中选中的商品
        List<CartVo> voCarts = cartService.getVOByCid(uid, cids);
        // 计算商品的总价
        long totalPrice = 0L;
        for(CartVo cartVo : voCarts){
            totalPrice += cartVo.getRealPrice() * cartVo.getNum();
        }
        Address address = addressService.findByAid(aid, uid);
        Order order = new Order();
        order.setUid(uid);
        //支付，总价
        order.setTotalPrice(totalPrice);
        order.setStatus(0);
        order.setOrderTime(new Date());
        //收货地址数据
        order.setRecvName(address.getName());
        order.setRecvArea(address.getAreaName());
        order.setRecvPhone(address.getPhone());
        order.setRecvCity(address.getCityName());
        order.setRecvProvince(address.getProvinceName());
        order.setRecvAddress(address.getAddress());
        //日志
        order.setCreatedTime(new Date());
        order.setModifiedTime(new Date());
        order.setModifiedUser(username);
        order.setCreatedUser(username);
        int rows = tOrderMapper.insert(order);
        if(rows!=1){
            throw new InsertException("插入时发生异常");
        }

        // 创建订单项数据
        for(CartVo cartVo : voCarts){
            OrderItem orderItem = new OrderItem();
            orderItem.setOid(order.getOid());
            orderItem.setPid(cartVo.getPid());
            orderItem.setNum(cartVo.getNum());
            orderItem.setPrice(cartVo.getRealPrice());
            orderItem.setImage(cartVo.getImage());
            orderItem.setTitle(cartVo.getTitle());
            orderItem.setCreatedTime(new Date());
            orderItem.setModifiedTime(new Date());
            orderItem.setModifiedUser(username);
            orderItem.setCreatedUser(username);
            rows = tOrderItemMapper.insert(orderItem);
            if(rows!=1){
                throw new InsertException("插入时发生异常");
            }
        }
        return order;
    }
}




