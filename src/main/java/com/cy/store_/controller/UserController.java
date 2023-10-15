package com.cy.store_.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cy.store_.controller.ex.*;
import com.cy.store_.entity.User;
import com.cy.store_.service.UserService;
import com.cy.store_.util.JsonResult;
import com.google.common.collect.Lists;
import org.apache.tomcat.util.http.fileupload.impl.FileUploadIOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/09/10/01:05
 */
@RestController  // @Controller + @ResponseBody
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    /**
     * 约定大于配置 ：省略大量的配置甚至注解
     * 1.接收数据方式：请求处理方法的参数列表设置为pojo类型来接收前端的数据
     *  SpringBoot 会将前端的url地址中的参数名和pojo类的属性名进行比较，如果这两个名称相同，
     *  则将值注入到pojo 类中对应的属性上
     */
    @RequestMapping(value = "reg" )
//    @ResponseBody // 表示此方法的响应结果以json格式进行数据的响应给到前端
    public JsonResult<Void> reg(@RequestBody User user){
        userService.reg(user);
        return new JsonResult<>(SUC);
    }

    /**
     * 2.接收数据方式：请求处理方法的参数列表设置为非pojo类型
     * Spring Boot 会直接将请求的参数名和方法的参数名直接进行比较，如果名称相同，则自动完成值的依赖注入
     */
    @RequestMapping(value = "login")
    public JsonResult<User> login(@RequestBody User user, HttpSession session){
        User data = userService.login(user);
        // session set 数据
        session.setAttribute("uid",data.getUid());
        session.setAttribute("username",data.getUsername());

        return new JsonResult<>(SUC,data);
    }

    @RequestMapping(value = "changePassword")
    public JsonResult<Void> changePassword(@RequestBody Map<String, Object> changeDate , HttpSession session){
        String oldPassword = (String) changeDate.get("oldPassword");
        String newPassword = (String) changeDate.get("newPassword");
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid,username,oldPassword, newPassword);
        return new JsonResult<>(SUC);
    }

    @RequestMapping(value = "getByUid")
    public JsonResult<User> getByUid(HttpSession session){
        User data = userService.getByUid(getUidFromSession(session));
        return new JsonResult<>(SUC,data);
    }

    @RequestMapping(value = "changeInfo")
    public JsonResult<Void> changeInfo(@RequestBody User user ,HttpSession session){
        Integer uid = getUidFromSession(session);
        userService.changeInfo(uid,user);
        return new JsonResult<>(SUC);
    }

    /** 限制文件上传的最大值*/
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;

    /** 限制文件上传类型*/
    public static final List<String> AVATAR_TYPE = Lists.newArrayList();
    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
    }

    @RequestMapping(value = "changeAvatar")
    public JsonResult<Void> changeAvatar(@RequestParam("file") MultipartFile file , HttpSession session) {
        if(file.isEmpty()){
            throw new FileEmptyException("文件为空");
        }
        if(file.getSize() > AVATAR_MAX_SIZE){
            throw new FileSizeException("文件超出限制");
        }
        String contentType = file.getContentType();
        if(!AVATAR_TYPE.contains(contentType)){
            throw new FileTypeException("文件类型不支持");
        }

        // 上传的文件
        String parent = session.getServletContext().getRealPath("upload");
        File dir = new File(parent);
        if(!dir.exists()){
            dir.mkdirs(); // 如果不存在，则创建目录
        }
        String originalFilename = file.getOriginalFilename();
        String fixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString().toUpperCase() + fixName;

        File dest = new File(dir, fileName); //先创建一个空文件
        try {
            file.transferTo(dest); // 将file文件中的数据写入到dest中
        }catch (IOException e){
           throw new FileIOException("文件读写异常");
        }

        Integer uid = getUidFromSession(session);
        String avatar = "/upload/" + fileName;
        String username = getUsernameFromSession(session);
        userService.changeAvatar(uid,avatar,username);
        return new JsonResult<>(SUC,avatar);
    }


}
