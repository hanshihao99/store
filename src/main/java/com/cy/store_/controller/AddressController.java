package com.cy.store_.controller;

import com.cy.store_.entity.Address;
import com.cy.store_.service.AddressService;
import com.cy.store_.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/09/24/00:06
 */
@RestController  // @Controller + @ResponseBody
@RequestMapping("address")
public class AddressController extends BaseController {
    @Autowired
    AddressService addressService;

    @RequestMapping(value = "add_new_address" )
    public JsonResult<Void> addNewAddress(Address address, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.addnewAddress(uid,username,address);
        return new JsonResult<>(SUC) ;
    }
}
