package com.cy.store_.mapper;

import com.cy.store_.entity.DictDistrict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
* @author hanshihao
* @description 针对表【t_dict_district】的数据库操作Mapper
* @createDate 2023-09-24 17:04:29
* @Entity com.cy.store_.entity.TDictDistrict
*/
@Mapper
public interface TDictDistrictMapper extends BaseMapper<DictDistrict> {

    Logger logger = LoggerFactory.getLogger(TDictDistrictMapper.class);


    /**
     * 根据父代号查询区域信息
     * @param parent 父代号
     * @return 返回某个父区域下边的所有列表
     */
    @Select("select * from t_dict_district where parent = #{parent}")
    List<DictDistrict> findByParent(String parent);

    @Select("select name from t_dict_district where code = #{code}")
    String findNameByCode(String code);

}




