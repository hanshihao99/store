package com.cy.store_.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cy.store_.entity.Product;
import com.cy.store_.entity.User;
import com.cy.store_.service.ProductService;
import com.cy.store_.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/10/11/22:31
 */
@RestController  // @Controller + @ResponseBody
@RequestMapping("products")
public class ProductController extends BaseController{

    @Autowired
    ProductService productService;

    @RequestMapping(value = "host_list" )
    public JsonResult<List<Product>> findHostList(){
        List<Product> hostList = productService.findHostList();
        return new JsonResult<>(SUC,hostList);
    }

    @RequestMapping(value = "findById" )
    public JsonResult<Product> findById(@RequestBody Product product){
        Product result = productService.findByid(product.getId());
        return new JsonResult<>(SUC,result);
    }

    @RequestMapping(value = "findByNameCount" )
    public JsonResult<Integer> findByNameCount(@RequestBody Product product){
        Integer count = productService.findCount(product.getItemType());
        return new JsonResult<>(SUC,count);
    }

    @RequestMapping(value = "findAll" )
    public JsonResult<IPage> findByNameCount(Integer current , Integer size){
        IPage all = productService.findAll(current,size);
        return new JsonResult<>(SUC,all);
    }

}
