package com.cy.store_.mapper;

import com.cy.store_.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.store_.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

/**
* @author hanshihao
* @description 针对表【t_order】的数据库操作Mapper
* @createDate 2023-10-15 20:02:25
* @Entity com.cy.store_.entity.TOrder
*/
@Mapper
public interface TOrderMapper extends BaseMapper<Order> {

    @Override
    int insert(Order order);

}




