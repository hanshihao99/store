package com.cy.store_.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.*;

/**
 * 
 * @TableName t_dict_district
 */
@TableName(value ="t_dict_district")
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class DictDistrict implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String parent;

    /**
     * 
     */
    private String code;

    /**
     * 
     */
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}