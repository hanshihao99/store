package com.cy.store_.controller;

import com.cy.store_.entity.Cart;
import com.cy.store_.entity.Order;
import com.cy.store_.modle.CartVo;
import com.cy.store_.service.CartService;
import com.cy.store_.service.OrderService;
import com.cy.store_.util.JsonResult;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/15/14:44
 */
@RestController  // @Controller + @ResponseBody
@RequestMapping("order")
public class OrderController extends BaseController{

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "createOrder" )
    public JsonResult<Order> createOrder(@RequestBody JsonNode jsonNode, HttpSession session){
        Integer aid = jsonNode.get("aid").asInt();
        JsonNode cidsNode = jsonNode.get("cids");
        Integer[] cids = new Integer[cidsNode.size()];
        for (int i = 0; i < cidsNode.size(); i++) {
            cids[i] = cidsNode.get(i).asInt();
        }
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        Order order = orderService.createOrder(aid, uid, username, cids);
        return new JsonResult<>(SUC,order);
    }



}
