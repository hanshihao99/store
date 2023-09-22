package com.cy.store_.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.store_.entity.Address;
import com.cy.store_.service.AddressService;
import com.cy.store_.mapper.TAddressMapper;
import org.springframework.stereotype.Service;

/**
* @author hanshihao
* @description 针对表【t_address】的数据库操作Service实现
* @createDate 2023-09-22 23:25:11
*/
@Service
public class AddressServiceImpl extends ServiceImpl<TAddressMapper, Address>
    implements AddressService {

}




