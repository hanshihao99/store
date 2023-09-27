package com.cy.store_.service.impl;

import com.cy.store_.entity.User;
import com.cy.store_.interceptor.LoginInterceptor;
import com.cy.store_.mapper.TUserMapper;
import com.cy.store_.service.UserService;
import com.cy.store_.service.ex.*;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @Description: 用户模块业务的实现类
 * @Auther: hanshihao
 * @Date: 2023/09/10/00:11
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    TUserMapper userMapper;

    // 用户注册方法
    @Override
    public void reg(User user) {
        // 首先判断用户是否依旧注册过，调用findUsername 判断用户是否被注册过
        String username = user.getUsername();
        User result = userMapper.findByUsername(username);
        System.out.println(result);
        //判断结果集是否为null 来抛出异常
        if(result != null){
            throw new UsernameDuplicatedException("用户名被占用");
        }

        //密码加密处理：MD5算法加密
        //盐指 + password + 盐值 --- MD5加密
        String oldPassword = user.getPassword();
        //获取盐值(随机生成一个盐值)，然后存入数据库中
        String salt = UUID.randomUUID().toString().toUpperCase();
        user.setSalt(salt);
        //密码加密
        String md5Password = getMD5Password(oldPassword, salt);
        user.setPassword(md5Password);

        //补全用户数据
        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        //执行注册业务功能的实现
        Integer rows = userMapper.inset(user);
        if(rows != 1){
            throw new InsertException("用户注册过程中发生了未知错误");
        }
    }


    @Override
    public User login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        // 根据用户名称来查询用户的数据是否存在 以及是否已经注销，如果不在则抛出异常
        User result = userMapper.findByUsername(username);
        System.out.println(result);
        if(result == null || result.getIsDelete() == 1){
            throw new UsernameNotFoundException("用户数据不存在");
        }
        // 检测用户的密码是否匹配
        // 1. 先获取到数据库中的加密之后的密码
        String oldPassword = result.getPassword();
        // 2.和用户的传递过来的密码进行比较
        // 2.1 先获取盐值：上一次注册时生成的盐值
        String salt = result.getSalt();
        // 2.2 将用户的密码md5加密
        String newMd5Password = getMD5Password(password,salt);
        // 3. 比较密码是否正确
        if(!newMd5Password.equals(oldPassword)){
            throw new PasswordNotMatchException("密码不正确 o-o-o");
        }

        // 登录成功后没必要返回当前用户的所有数据，可以择机选择，提高性能
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());

        logger.info("username : " + username);

        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        System.out.println(result);
        if(result == null || result.getIsDelete() ==1){
            throw new UsernameNotFoundException("用户数据不存在");
        }
        oldPassword = getMD5Password(oldPassword ,result.getSalt());
        if(!result.getPassword().equals(oldPassword)){
            throw new PasswordNotMatchException("密码错误");
        }

        newPassword = getMD5Password(newPassword,result.getSalt());
        Integer rows = userMapper.updatePasswordByUid(uid, newPassword, username, new Date());
        if(rows!=1){
            throw new UpdateException("更新用户密码时发生异常");
        }
    }

    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete()==1){
            throw new UsernameNotFoundException("用户数据不存在");
        }
        // 生成user对象只传递关键信息，剩余信息冗余，可以不传，效率更高。如果需要数据都传递回去，直接return result即可
        User user = new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());

        return user;
    }


    @Override
    public void changeInfo(Integer uid, User user) {
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete()==1){
            throw new UsernameNotFoundException("用户数据不存在");
        }
        user.setUid(uid);
        user.setModifiedUser(user.getUsername());
        Integer rows = userMapper.updateInfoByUid(user);
        if(rows != 1){
            throw new UpdateException("更新用户数据时产生未知的异常");
        }
    }

    @Override
    public void changeAvatar(Integer uid, String avatar , String username) {
        User result = userMapper.findByUid(uid);
        if(result == null || result.getIsDelete()==1){
            throw new UsernameNotFoundException("用户数据不存在");
        }

        Integer rows = userMapper.updateAvatarByUid(uid,avatar,username);
        if(rows != 1){
            throw new UpdateException("更新头像数据时产生未知的异常");
        }
    }

    // 测试@Param 注解
//    @Override
//    public void changeAvatar(Integer uid, User user) {
//        User result = userMapper.findByUid(uid);
//        if(result == null || result.getIsDelete()==1){
//            throw new UsernameNotFoundException("用户数据不存在");
//        }
//        user.setUid(uid);
//        user.setModifiedUser(result.getModifiedUser());
//        Integer rows = userMapper.updateAvatarByUid(user.getAvatar(),user.getModifiedUser(),user.getUid());
//        if(rows != 1){
//            throw new UpdateException("更新数据时产生未知的异常");
//        }
//    }

    /**
     * 定义一个MD5算法加密
     */
    public String getMD5Password(String password , String salt){
        // 加密算法的调用
        password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        return password;
    }
}
