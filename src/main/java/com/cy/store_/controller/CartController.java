package com.cy.store_.controller;

import com.cy.store_.entity.Cart;
import com.cy.store_.modle.CartVo;
import com.cy.store_.service.CartService;
import com.cy.store_.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/15/14:44
 */
@RestController  // @Controller + @ResponseBody
@RequestMapping("carts")
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

    @RequestMapping(value = {"/",""} )
    public JsonResult<List<CartVo>> getVOByUid(HttpSession session){
        Integer uid = getUidFromSession(session);
        List<CartVo> resultList = cartService.getVOByUid(uid);
        return new JsonResult<>(SUC,resultList);
    }

    @RequestMapping(value = "{cid111}/num/add" )
    //@PathVariable("cid111") 表示你要从请求的 URL 中提取名为 "cid111" 的路径变量的值，并将其绑定到 Integer cid 方法参数上。
    public JsonResult<Integer> addNum(@PathVariable("cid111") Integer cid, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        Integer data = cartService.addNum(cid, uid, username);
        return new JsonResult<>(SUC,data);
    }

    @RequestMapping(value = "{cid}/num/del" )
    public JsonResult<Integer> delNum(@PathVariable Integer cid, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        Integer data = cartService.delNum(cid, uid, username);
        return new JsonResult<>(SUC,data);
    }

    @RequestMapping(value = "lists" )
    public JsonResult<List<CartVo>> getVOByCid(Integer[] cids, HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<CartVo> result = cartService.getVOByCid(uid, cids);
        return new JsonResult<>(SUC,result);
    }

    // http://localhost:8080/carts/cartslist/123/1,2,3,4    调用的url
    @RequestMapping(value = "cartslist/{aid}/{cid111}")
    public JsonResult<List<CartVo>> getVOByCidTest(@PathVariable Integer aid,@PathVariable("cid111") List<Integer> cids, HttpSession session) {
        Integer uid = getUidFromSession(session);
        // System.out.println(aid);  // 可输出aid的值
        List<CartVo> result = cartService.getVOByCidTest(uid, cids);
        return new JsonResult<>(SUC,result);
    }
}
