package com.itheima.bigeventbackend.service;

import com.itheima.bigeventbackend.pojo.User;

public interface UserService {
    public User findByName(String username);

    void register(String username, String password);
}
