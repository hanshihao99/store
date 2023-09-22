package com.cy.store_.mapper;

import com.cy.store_.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
* @author hanshihao
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2023-09-09 16:38:48
* @Entity base.entity.TUser
*/

@Mapper
public interface TUserMapper {

    @Insert(" insert into t_user (username,\n" +
            "                            password,\n" +
            "                            salt,\n" +
            "                            phone,\n" +
            "                            email,\n" +
            "                            gender,\n" +
            "                            avatar,\n" +
            "                            is_delete,\n" +
            "                            created_user,\n" +
            "                            created_time,\n" +
            "                            modified_user,\n" +
            "                            modified_time)\n" +
            "        VALUES (#{username},\n" +
            "                #{password},\n" +
            "                #{salt},\n" +
            "                #{phone},\n" +
            "                #{email},\n" +
            "                #{gender},\n" +
            "                #{avatar},\n" +
            "                #{isDelete},\n" +
            "                #{createdUser},\n" +
            "                #{createdTime},\n" +
            "                #{modifiedUser},\n" +
            "                #{modifiedTime})")
    Integer inset(User user);

    @Select("SELECT * FROM t_user where username = #{username}")
    User findByUsername(String username);

    @Select("SELECT * FROM t_user ")
    List<User> findAll();


    /**
     * 根据uid更新密码
     * @param uid 用户id
     * @param password 新密码
     * @param modifiedUser 修改者
     * @param modifiedTime 修改时间
     * @return 影响的行数
     */
    @Update("update t_user set password = #{password} , modified_user = #{modifiedUser} , modified_time = #{modifiedTime} where uid = #{uid}")
    Integer updatePasswordByUid(Integer uid , String password, String modifiedUser, Date modifiedTime);

    /**
     * 根据uid查找记录
     * @param uid 用户id
     * @return 如果找到则返回对象 ，没有则返回为null
     */
    @Select("select * from t_user where uid = #{uid}")
    User findByUid(Integer uid);

    @Update("<script>"
            + "UPDATE t_user"
            + " <set> "
            + "     <if test='phone != null'>"
            + "          phone = #{phone},"
            + "     </if>"
            + "     <if test='email != null'>"
            + "          email = #{email}," + "     </if>"
            + "     <if test='gender != null'>"
            + "          gender = #{gender},"
            + "     </if>"
            + "          modified_user = #{modifiedUser},"
            + "     modified_time = CURRENT_TIMESTAMP,"
            + " </set>"
            + " where uid = #{uid}"
            + "</script>")
    Integer updateInfoByUid(User user);

    @Update("<script>"
            + "UPDATE t_user"
            + " <set> "
            + "     <if test='ava != null'>"
            + "          avatar = #{ava},"
            + "     </if>"
            + "     modified_user = #{modifiedUser},"
            + "     modified_time = CURRENT_TIMESTAMP,"
            + " </set>"
            + " where uid = #{uid}"
            + "</script>")
    // @Param 定义 sql语句中 #{} 中的变量名
    Integer updateAvatarByUid( Integer uid , @Param("ava") String avatar , @Param("modifiedUser") String modifiedUser );


//    使用@Param 注解，测试用法
//    @Update("<script>"
//            + "UPDATE t_user"
//            + " <set> "
//            + "     <if test='ava != null'>"
//            + "          avatar = #{ava},"
//            + "     </if>"
//            + "     modified_user = #{modiu},"
//            + "     modified_time = CURRENT_TIMESTAMP,"
//            + " </set>"
//            + " where uid = #{uid}"
//            + "</script>")
//    Integer updateAvatarByUid(@Param("ava") String avatar , @Param("modiu") String modiyyy, Integer uid);
}



