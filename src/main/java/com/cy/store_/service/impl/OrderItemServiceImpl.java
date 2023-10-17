package com.cy.store_.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.store_.entity.OrderItem;
import com.cy.store_.service.OrderItemService;
import com.cy.store_.mapper.TOrderItemMapper;
import org.springframework.stereotype.Service;

/**
* @author hanshihao
* @description 针对表【t_order_item】的数据库操作Service实现
* @createDate 2023-10-15 21:22:10
*/
@Service
public class OrderItemServiceImpl extends ServiceImpl<TOrderItemMapper, OrderItem>
    implements OrderItemService {

}




