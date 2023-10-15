package com.cy.store_.service;

import com.cy.store_.entity.Address;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cy.store_.mapper.TAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
* @author hanshihao
* @description 针对表【t_address】的数据库操作Service
* @createDate 2023-09-22 23:25:11
*/
public interface AddressService extends IService<Address> {

    void addnewAddress(Integer uid, String username , Address address);

    List<Address> findByUid(Integer uid);

    void updateAddress(Integer uid, String username , Address address);

    void setDefault(Integer aid , Integer uid , String username);

    void deleteAddress(Integer aid, Integer uid,String username);

}
