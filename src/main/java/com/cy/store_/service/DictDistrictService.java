package com.cy.store_.service;

import com.cy.store_.entity.DictDistrict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author hanshihao
* @description 针对表【t_dict_district】的数据库操作Service
* @createDate 2023-09-24 17:04:29
*/
public interface DictDistrictService extends IService<DictDistrict> {

    /**
     * 根据父代号查询区域的信息
     * @param parent 父代号
     * @return 返回区域信息
     */
    List<DictDistrict> getByParent(String parent);

    String getNameByCode(String code);
}
