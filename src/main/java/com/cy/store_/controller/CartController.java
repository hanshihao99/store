package com.cy.store_.controller;

import com.cy.store_.entity.Cart;
import com.cy.store_.service.CartService;
import com.cy.store_.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/15/14:44
 */
@RestController  // @Controller + @ResponseBody
@RequestMapping("cart")
public class CartController extends BaseController{

    @Autowired
    CartService cartService;

    @RequestMapping(value = "updateCart" )
    public JsonResult<Void> updateCart(@RequestBody Cart cart, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        cartService.updateCart(uid,cart.getPid(),cart.getNum(),username);
        return new JsonResult<>(SUC);
    }
}
