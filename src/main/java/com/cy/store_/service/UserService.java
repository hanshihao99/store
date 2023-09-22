package com.cy.store_.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cy.store_.entity.User;
import org.springframework.stereotype.Service;

/**
* @author hanshihao
* @description 针对表【t_user】的数据库操作Service
* @createDate 2023-09-09 16:38:48
*/
public interface UserService {
        /**
         * 用户注册功能
         * @param user 用户数据
         */
        public abstract void reg(User user);
        /**
         * 用户登录功能
         * @param user 用户,输入用户名和密码
         * @return 当前匹配的用户数据，如果没有则返回null
         */
        public abstract User login(User user);

        public abstract void changePassword(Integer uid , String username , String oldPassword , String newPassword);

        /**
         * 根据用户的id 查询用户的数据
         * @param uid
         * @return
         */
        User getByUid(Integer uid);

        /**
         * 更新用户数据的操作
         * @param uid 用户的uid ， 从session 中获取
         * @param user 用户对象的数据
         */
        void changeInfo(Integer uid  , User user);

        /**
         * 修改用户头像
         * @param uid 用户的id
         * @param avatar 用户的头像
         * @param username 用户名
         */
        void changeAvatar(Integer uid , String avatar , String username);

}
