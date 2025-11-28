package com.itheima.bigeventbackend.service;

import com.itheima.bigeventbackend.pojo.User;

public interface UserService {
    /**
     * 根据username在User表中查找数据
     * @param username 用户名
     * @return 查找到的用户信息
     */
    public User findByName(String username);

    /**
     * 注册用户
     * @param username 用户名
     * @param password 密码
     */
    void register(String username, String password);
}
