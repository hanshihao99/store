package com.cy.store_.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.*;

/**
 * 
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BaseEntity implements Serializable {

    /**
     * 创建用户
     */
    private String createdUser;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改用户
     */
    private String modifiedUser;

    /**
     * 修改时间
     */
    private Date modifiedTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}