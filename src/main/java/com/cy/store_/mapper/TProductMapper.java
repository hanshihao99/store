package com.cy.store_.mapper;

import com.cy.store_.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author hanshihao
* @description 针对表【t_product】的数据库操作Mapper
* @createDate 2023-10-11 22:09:06
* @Entity com.cy.store_.entity.TProduct
*/
@Mapper
public interface TProductMapper extends BaseMapper<Product> {

    /**
     * 查询热销商品前四名的集合
     * @return 热销商品集合
     */
    @Select("select * from t_product where status = 1 order by priority desc limit 0,4")
    List<Product> findHostList();

    @Select("select * from t_product where id = #{id}")
    Product findByid(Integer id);

}




