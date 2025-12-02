package com.itheima.bigeventbackend.service.impl;


import com.itheima.bigeventbackend.mapper.UserMapper;
import com.itheima.bigeventbackend.pojo.User;
import com.itheima.bigeventbackend.service.UserService;
import com.itheima.bigeventbackend.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 根据username在User表中查找数据
     * @param username 用户名
     * @return 查找到的用户信息
     */
    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    /**
     * 注册用户
     * @param username 用户名
     * @param password 密码
     */
    @Override
    public void register(String username, String password) {
//        1.将密码用MD5加密
        password = Md5Util.getMD5String(password);
//        2.封装数据
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
//        3.向数据库插入数据
        userMapper.add(user);
    }

    @Override
    public void update(User user) {
//        更新数据库中数据的更新时间
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.updateAvatar(user);
    }

    @Override
    public void updatePwd(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.updatePwd(user);
    }
}
