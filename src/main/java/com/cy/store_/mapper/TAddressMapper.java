package com.cy.store_.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.cy.store_.entity.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.store_.entity.DictDistrict;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.io.Serializable;
import java.util.List;

/**
* @author hanshihao
* @description 针对表【t_address】的数据库操作Mapper
* @createDate 2023-09-22 23:25:11
* @Entity com.cy.store_.entity.TAddress
*/
//@Mapper
public interface TAddressMapper extends BaseMapper<Address> {

    /**
     *  插入收货地址数据
     * @param address 收货地址总数
     * @return 影响行数
     */
    @Override
    int insert(Address address);

    @Override
    int update(Address entity, Wrapper<Address> updateWrapper);

    @Update("<script>"
            +"UPDATE t_address"
            + "<set>"
            + "<if test = 'address != null'>"
            + "address = #{address},"
            + "</if>"
            + "<if test = 'phone != null'>"
            + "phone = #{phone},"
            + "</if>"
            + "<if test = 'name != null'>"
            + "name = #{name},"
            + "</if>"
            + "     modified_user = #{modifiedUser},"
            + "     modified_time = CURRENT_TIMESTAMP,"
            + "</set>"
            + " where aid = #{aid}"
            + "</script>")
    int updateAddress(Address address);

    /**
     * 根据用户的id统计收货地址数量
     * @param uid 用户id
     * @return 收货地址数量
     */
    @Select("SELECT count(*) from t_address where uid = #{uid}")
    int countByUid(Integer uid);

    /**
     * 根据用户id查询收货地址
     * @param uid 用户id
     * @return 收货地址
     */
    @Select("select * from t_address where uid = #{uid} order by is_default desc , created_time desc")
    List<Address> findByUid(Integer uid);


    @Select("select * from t_address where aid = #{aid}")
    Address findAid(Integer aid);


    @Update("update t_address set is_default = 0 where uid = #{uid}")
    Integer updateNonDefault(Integer uid);

    @Update("update t_address " +
            "set is_default = 1 ," +
            " modified_user = #{modifiedUser} ," +
            " modified_time = CURRENT_TIMESTAMP " +
            "where aid = #{aid}")
    Integer updateDefaultByAid(Integer aid , String modifiedUser);

    /**
     * 删除指定的收货地址数据
     * @param aid 收货地址id
     * @return 受影响的行数
     */
    @Delete("delete from t_address where aid = #{aid}")
    Integer deleteByAid(Integer aid);

    /**
     * 查询最近一次修改的收货地址数据
     * @param uid 用户id
     * @return 收货地址数据
     */
    @Select("select * from t_address where uid = #{uid} order by modified_time DESC limit 0,1")
    Address findLastModified(Integer uid);


}




