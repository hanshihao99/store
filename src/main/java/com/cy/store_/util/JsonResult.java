package com.cy.store_.util;

import lombok.*;

import java.io.Serializable;

/**
 * @Description: Json格式的数据相应。需要实现可序列化
 * @Auther: hanshihao
 * @Date: 2023/09/10/00:55
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@Builder  //会自动生成一个名为builder()的静态方法，用于创建建造者对象，本身的构造方法会设置为private，需要在本路径下创建新的util类使用，例如BuildSuccess，封装后使用
public class JsonResult<E> implements Serializable {
    /** 状态码 */
    private Integer state;
    /** 描述信息 */
    private String message;
    /** 数据 */
    private E data;

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public JsonResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }
}
