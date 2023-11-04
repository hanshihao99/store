package com.cy.store_.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.store_.entity.Product;
import com.cy.store_.service.ProductService;
import com.cy.store_.mapper.TProductMapper;
import com.cy.store_.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
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

    @Override
    public Integer findCount(String name) {
        QueryWrapper query = new QueryWrapper();
        query.eq("item_type",name);
        Integer integer = tProductMapper.selectCount(query);
        return integer;
    }

    @Override
    public IPage findAll(Integer current , Integer size) {
        Page<Product> page = new Page(current,size);
        IPage<Product> productIPage = tProductMapper.selectPage(page, null);
        return productIPage;
    }
}




