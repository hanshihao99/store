package com.cy.store_.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cy.store_.entity.DictDistrict;
import com.cy.store_.service.DictDistrictService;
import com.cy.store_.mapper.TDictDistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author hanshihao
* @description 针对表【t_dict_district】的数据库操作Service实现
* @createDate 2023-09-24 17:04:29
*/
@Service
public class DictDistrictServiceImpl extends ServiceImpl<TDictDistrictMapper, DictDistrict>
    implements DictDistrictService {

    @Autowired
    TDictDistrictMapper tDictDistrictMapper;

    @Override
    public List<DictDistrict> getByParent(String parent) {
        List<DictDistrict> dictList = tDictDistrictMapper.findByParent(parent);
        // 在进行网络传输时，为尽量避免无效数据的传递，可以讲无效数据设置为null，节省流量，提升效率
        for(DictDistrict dict : dictList){
            dict.setId(null);
            dict.setParent(null);
        }
        return dictList;
    }

    @Override
    public String getNameByCode(String code) {
        return tDictDistrictMapper.findNameByCode(code);
    }
}




