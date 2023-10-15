package com.cy.store_.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.store_.entity.Product;
import com.cy.store_.service.ProductService;
import com.cy.store_.mapper.TProductMapper;
import com.cy.store_.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hanshihao
 * @description 针对表【t_product】的数据库操作Service实现
 * @createDate 2023-10-11 22:09:06
 */
@Service
public class ProductServiceImpl extends ServiceImpl<TProductMapper, Product>
        implements ProductService {

    @Autowired
    TProductMapper tProductMapper;

    @Override
    public List<Product> findHostList() {
        List<Product> hostList = tProductMapper.findHostList();
        if (hostList == null) {
            throw new ProductNotFoundException("商品不存在");
        }
        for (Product product : hostList) {
            product.setPriority(null);
            product.setCreatedUser(null);
            product.setCreatedTime(null);
            product.setModifiedTime(null);
            product.setModifiedUser(null);
        }
        return hostList;
    }

    @Override
    public Product findByid(Integer id) {
        Product product = tProductMapper.findByid(id);
        if (product == null) {
            throw new ProductNotFoundException("商品不存在");
        }
        product.setPriority(null);
        product.setCreatedUser(null);
        product.setCreatedTime(null);
        product.setModifiedTime(null);
        product.setModifiedUser(null);
        return product;
    }
}




