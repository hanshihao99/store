package com.cy.store_.service;

import com.cy.store_.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author hanshihao
* @description 针对表【t_product】的数据库操作Service
* @createDate 2023-10-11 22:09:06
*/
public interface ProductService extends IService<Product> {

    List<Product> findHostList();

    Product findByid(Integer id);

}
