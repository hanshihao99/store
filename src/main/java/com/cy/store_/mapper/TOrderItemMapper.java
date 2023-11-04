package com.cy.store_.mapper;

import com.cy.store_.entity.OrderItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hanshihao
* @description 针对表【t_order_item】的数据库操作Mapper
* @createDate 2023-10-15 21:22:10
* @Entity com.cy.store_.entity.TOrderItem
*/
//@Mapper
public interface TOrderItemMapper extends BaseMapper<OrderItem> {

    @Override
    int insert(OrderItem entity);
}




