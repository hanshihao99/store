package com.cy.store_.controller;

import com.cy.store_.entity.Address;
import com.cy.store_.entity.User;
import com.cy.store_.service.AddressService;
import com.cy.store_.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public JsonResult<Void> addNewAddress(@RequestBody Address address, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.addnewAddress(uid,username,address);
        return new JsonResult<>(SUC) ;
    }

    @RequestMapping(value ={ "","/"} )
    public JsonResult<List<Address>> findByUid(HttpSession session){
        Integer uid = getUidFromSession(session);
        List<Address> listAddress = addressService.findByUid(uid);
        return new JsonResult<>(SUC,listAddress) ;
    }

    @RequestMapping(value ="update_address" )
    public JsonResult<Void> updateAddress(@RequestBody Address address , HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.updateAddress(uid,username,address);
        return new JsonResult<>(SUC) ;
    }

    @RequestMapping(value ="set_default" )
    public JsonResult<Void> setDefault(@RequestBody Address address , HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.setDefault(address.getAid(),uid,username);
        return new JsonResult<>(SUC) ;
    }

    @RequestMapping(value ="delete_address" )
    public JsonResult<Void> deleteAddress(@RequestBody Address address , HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.deleteAddress(address.getAid(),uid,username);
        return new JsonResult<>(SUC) ;
    }
}
