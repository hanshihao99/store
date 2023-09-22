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
 * @TableName t_address
 */
@TableName(value ="t_address")
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Address implements Serializable {
    /**
     * 收货地址
     */
    @TableId(type = IdType.AUTO)
    private Integer aid;

    /**
     * ¹用户id
     */
    private Integer uid;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 省名称
     */
    private String provinceName;

    /**
     * 省代号
     */
    private String provinceCode;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 城市代号
     */
    private String cityCode;

    /**
     * 区名称
     */
    private String areaName;

    /**
     * 区代号
     */
    private String areaCode;

    /**
     * 邮政编码
     */
    private String zip;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 固定电话
     */
    private String tel;

    /**
     * 标签
     */
    private String tag;

    /**
     * 是否默认地址：0-不默认，1-默认
     */
    private Integer isDefault;

    /**
     * 创建人
     */
    private String createdUser;

    /**
     * 修改人
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