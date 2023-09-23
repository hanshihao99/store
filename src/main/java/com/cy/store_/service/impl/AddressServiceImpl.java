package com.cy.store_.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.store_.entity.Address;
import com.cy.store_.service.AddressService;
import com.cy.store_.mapper.TAddressMapper;
import com.cy.store_.service.ex.AddressCountLimitException;
import com.cy.store_.service.ex.InsertException;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.Current;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author hanshihao
* @description 针对表【t_address】的数据库操作Service实现
* @createDate 2023-09-22 23:25:11
*/
@Service
public class AddressServiceImpl extends ServiceImpl<TAddressMapper, Address>
    implements AddressService {

    @Autowired
    TAddressMapper tAddressMapper;

    @Value("${user.address.max-count}")
    private Integer countMax;

    @Override
    public void addnewAddress(Integer uid, String username, Address address) {
        Integer count = tAddressMapper.countByUid(uid);
        if(count >= countMax){
            throw new AddressCountLimitException("用户收货地址超出上限");
        }

        address.setUid(uid);
        Integer isDefault = count == 0 ? 1 : 0;
        address.setIsDefault(isDefault);
        address.setCreatedUser(username);
        address.setCreatedTime(new Date());
        address.setModifiedUser(username);
        address.setModifiedTime(new Date());
        int rows = tAddressMapper.insert(address);
        if(rows!=1){
            throw new InsertException("插入用户地址时发生异常");
        }
    }
}




