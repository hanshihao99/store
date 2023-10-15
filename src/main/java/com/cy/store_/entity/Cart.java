package com.cy.store_.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.*;

/**
 * 
 * @TableName t_cart
 */
@TableName(value ="t_cart")
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Cart implements Serializable {
    /**
     * 购物车数据id
     */
    @TableId(type = IdType.AUTO)
    private Integer cid;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 商品id
     */
    private Integer pid;

    /**
     * 商品单价
     */
    private Long price;

    /**
     * 商品数量
     */
    private Integer num;

    /**
     * 创建者
     */
    private String createdUser;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改者
     */
    private String modifiedUser;

    /**
     * 修改时间
     */
    private Date modifiedTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}