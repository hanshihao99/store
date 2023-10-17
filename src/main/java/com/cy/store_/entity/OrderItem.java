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
 * @TableName t_order_item
 */
@TableName(value ="t_order_item")
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OrderItem implements Serializable {
    /**
     * 订单中的商品记录的id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 归属订单id
     */
    private Integer oid;

    /**
     * 商品id
     */
    private Integer pid;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品图片
     */
    private String image;

    /**
     * 商品价格
     */
    private Long price;

    /**
     * 购买数量
     */
    private Integer num;

    /**
     * 创建人
     */
    private String createdUser;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改人
     */
    private String modifiedUser;

    /**
     * 修改时间
     */
    private Date modifiedTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}