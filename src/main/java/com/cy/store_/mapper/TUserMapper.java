package com.cy.store_.mapper;

import com.cy.store_.entity.BaseEntity;
import com.cy.store_.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

//    User findByUsername(String username);

    @Select("SELECT * FROM t_user ")
    List<User> findAll();

}




