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
 * @TableName t_order
 */
@TableName(value ="t_order")
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Order implements Serializable {
    /**
     * 订单id
     */
    @TableId(type = IdType.AUTO)
    private Integer oid;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 收货人姓名
     */
    private String recvName;

    /**
     * 收货人手机号
     */
    private String recvPhone;

    /**
     * 收货人所在省份
     */
    private String recvProvince;

    /**
     * 收货人所在城市
     */
    private String recvCity;

    /**
     * 收货人所在区域
     */
    private String recvArea;

    /**
     * 收货人实际住址
     */
    private String recvAddress;

    /**
     * 总价
     */
    private Long totalPrice;

    /**
     * 状态 ： 0未支付，1已支付，2已取消，3已关闭，4已完成
     */
    private Integer status;

    /**
     * 下单时间
     */
    private Date orderTime;

    /**
     * 支付时间
     */
    private Date payTime;

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