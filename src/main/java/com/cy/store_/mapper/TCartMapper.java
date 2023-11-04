package com.cy.store_.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.cy.store_.entity.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cy.store_.modle.CartVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author hanshihao
* @description 针对表【t_cart】的数据库操作Mapper
* @createDate 2023-10-14 22:40:15
* @Entity com.cy.store_.entity.TCart
*/
//@Mapper
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

    @Select("select" +
            "     cid,uid,pid,t1.price,t1.num,t2.title,t2.image,t2.price as realPrice " +
            "from t_cart t1 left join t_product t2 on t1.pid = t2.id " +
            "where uid = #{uid} order by t1.modified_time desc")
    List<CartVo> getVOByUid(Integer uid);

    @Select("select * from t_cart where cid = #{cid}")
    Cart findByCid(Integer cid);

//    @Select("<script>" +
//            "SELECT cid, uid, pid, t1.price, t1.num, t2.title, t2.image, t2.price AS realPrice " +
//            "FROM t_cart t1 " +
//            "LEFT JOIN t_product t2 ON t1.pid = t2.id " +
//            "WHERE cid IN " +
//            "<foreach collection='array' item='cid' separator=',' >" +
//            "#{cid}" +
//            "</foreach>" +
//            "ORDER BY t1.modified_time DESC" +
//            "</script>")
//    List<CartVo> getVOByCid1(Integer[] cids);


    @Select({
            "<script>",
            "SELECT cid, uid, pid, t1.price, t1.num, t2.title, t2.image, t2.price AS realPrice ",
            "FROM t_cart t1 ",
            "LEFT JOIN t_product t2 ON t1.pid = t2.id ",
            "WHERE cid IN ",
            "<foreach collection='cids' item='cid' separator=',' open='(' close=')'>",
            "#{cid}",
            "</foreach>",
            "ORDER BY t1.modified_time DESC",
            "</script>"
    })
    List<CartVo> getVOByCid(Integer[] cids);

    @Select({
            "<script>",
            "SELECT cid, uid, pid, t1.price, t1.num, t2.title, t2.image, t2.price AS realPrice ",
            "FROM t_cart t1 ",
            "LEFT JOIN t_product t2 ON t1.pid = t2.id ",
            "WHERE cid IN ",
            "<foreach collection='cids' item='cid' separator=',' open='(' close=')'>",
            "#{cid}",
            "</foreach>",
            "ORDER BY t1.modified_time DESC",
            "</script>"
    })
    List<CartVo> getVOByCidTest(List<Integer> cids);

}




