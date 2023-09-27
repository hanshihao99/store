package com.cy.store_.controller;

import com.cy.store_.entity.DictDistrict;
import com.cy.store_.service.DictDistrictService;
import com.cy.store_.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/09/24/18:01
 */
@RestController  // @Controller + @ResponseBody
@RequestMapping("districts")
public class DistrictController extends BaseController{

    @Autowired
    DictDistrictService dictDistrictService;

    @RequestMapping(value = {"/",""} )
    public JsonResult<List<DictDistrict>> getByParent(@RequestBody DictDistrict district){
        List<DictDistrict> dictList = dictDistrictService.getByParent(district.getParent());
        return new JsonResult<>(SUC,dictList);

    }

}
