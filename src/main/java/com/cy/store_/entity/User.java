package com.cy.store_.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @Description: 用户的实体类
 * @Auther: hanshihao
 * @Date: 2023/09/09/16:55
 */
@TableName(value ="t_user")
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User extends BaseEntity {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别 女-0，男-1
     */
    private Integer gender;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 是否删除 0-未删除，1-已删除
     */
    private Integer isDelete;


}
