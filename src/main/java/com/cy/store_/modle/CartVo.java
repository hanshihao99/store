package com.cy.store_.modle;

import lombok.*;

import java.net.Inet4Address;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/15/15:38
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartVo {
    Integer cid;
    Integer uid;
    Integer pid;
    Long price;
    Integer num;
    String title;
    String image;
    Long realPrice;
}
