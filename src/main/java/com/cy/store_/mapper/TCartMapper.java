package com.cy.store_.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.cy.store_.entity.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
* @author hanshihao
* @description 针对表【t_cart】的数据库操作Mapper
* @createDate 2023-10-14 22:40:15
* @Entity com.cy.store_.entity.TCart
*/
@Mapper
public interface TCartMapper extends BaseMapper<Cart> {

    /**
     *  加入购物车
     * @param cart 实体对象
     * @return 受影响的行数
     */
    @Override
    int insert(Cart cart);

    /**
     * 更新购物车的数量
     * @param num 新增的数量
     * @param cid 购物商品id
     * @param modifiedUser 修改者
     * @return 受影响的行数
     */
    @Update("<script>"
            + "UPDATE t_cart"
            + " <set> "
            + "     <if test='num != null'>"
            + "          num = #{num},"
            + "     </if>"
            + "     modified_user = #{modifiedUser},"
            + "     modified_time = CURRENT_TIMESTAMP,"
            + " </set>"
            + " where cid = #{cid}"
            + "</script>")
    int updateNumByProduct(Integer num,Integer cid, String modifiedUser);

    @Select("select * from t_cart where pid = #{pid} and uid = #{uid}  ")
    Cart searchByProduct(Integer uid,Integer pid);
}




