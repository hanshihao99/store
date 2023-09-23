package com.cy.store_.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.cy.store_.entity.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;

/**
* @author hanshihao
* @description 针对表【t_address】的数据库操作Mapper
* @createDate 2023-09-22 23:25:11
* @Entity com.cy.store_.entity.TAddress
*/
@Mapper
public interface TAddressMapper extends BaseMapper<Address> {

    /**
     *  插入收货地址数据
     * @param address 收货地址总数
     * @return 影响行数
     */
    @Override
    int insert(Address address);


    /**
     * 根据用户的id统计收货地址数量
     * @param uid 用户id
     * @return 收货地址数量
     */
    @Select("SELECT count(*) from t_address where uid = #{uid}")
    int countByUid(Integer uid);
}




