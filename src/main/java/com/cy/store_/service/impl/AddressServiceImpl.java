package com.cy.store_.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.store_.entity.Address;
import com.cy.store_.mapper.TDictDistrictMapper;
import com.cy.store_.service.AddressService;
import com.cy.store_.mapper.TAddressMapper;
import com.cy.store_.service.DictDistrictService;
import com.cy.store_.service.ex.*;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.Current;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    DictDistrictService dictDistrictService;

    @Value("${user.address.max-count}")
    private Integer countMax;

    @Override
    public void addnewAddress(Integer uid, String username, Address address) {
        Integer count = tAddressMapper.countByUid(uid);
        if(count >= countMax){
            throw new AddressCountLimitException("用户收货地址超出上限");
        }

        // 使用省市区service 来补全地址的省市地址信息
        String provinceName = dictDistrictService.getNameByCode(address.getProvinceCode());
        String cityName = dictDistrictService.getNameByCode(address.getCityCode());
        String areaName = dictDistrictService.getNameByCode(address.getAreaCode());
        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);

        address.setUid(uid);
        Integer isDefault = count == 0 ? 1 : 0; // 1表示默认 ，0表示不默认
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

    @Override
    public List<Address> findByUid(Integer uid) {
        List<Address> listAddress = tAddressMapper.findByUid(uid);
        List<Address> addresses = new ArrayList();
        Address ad = new Address();
        for(int i = 0;i< listAddress.size();i++ ){
            ad.setName(listAddress.get(i).getName());
            ad.setAddress(listAddress.get(i).getAddress());
            ad.setPhone(listAddress.get(i).getPhone());
            ad.setTag(listAddress.get(i).getTag());
            addresses.add(ad);
        }

        return addresses;
    }

    @Override
    @Transactional(rollbackFor = Exception.class) // 添加事务控制
    public void setDefault(Integer aid, Integer uid, String username) {
        Address result = tAddressMapper.findAid(aid);
        if(result == null){
            throw new AddressNotFoundException("收货地址不存在");
        }
        // 检测当前收货地址的归属
        if(!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        Integer rows = tAddressMapper.updateNonDefault(result.getUid());
        if(rows < 1){
            throw new UpdateException("更新数据产生异常");
        }
        // 将用户选择的地址设置为默认收货地址
        rows = tAddressMapper.updateDefaultByAid(aid, username);
        if(rows!=1){
            throw new UpdateException("更新数据产生异常");
        }

    }

    @Override
    public void deleteAddress(Integer aid, Integer uid, String username) {
        Address result = tAddressMapper.findAid(aid);
        if(result == null){
            throw new AddressNotFoundException("收货地址不存在");
        }
        if(!result.getUid().equals(uid)){
            throw new AccessDeniedException("非法数据访问");
        }
        Integer isDefault = result.getIsDefault();

        Integer rows = tAddressMapper.deleteByAid(aid);
        if(rows != 1){
            throw new DeleteException("删除地址时发生异常");
        }

        if(isDefault == 0){
            return;
        }

        Integer count = tAddressMapper.countByUid(uid);
        if(count == 0){
            return;
        }

        Address lastModified = tAddressMapper.findLastModified(uid);
        rows = tAddressMapper.updateDefaultByAid(lastModified.getAid(), username);
        if(rows != 1){
            throw new UpdateException("更新数据产生异常");
        }

    }
}




