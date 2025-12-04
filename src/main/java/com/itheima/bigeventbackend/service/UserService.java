package com.itheima.bigeventbackend.service;

import com.itheima.bigeventbackend.DTO.request.UserUpdateUserInfoDTO;
import com.itheima.bigeventbackend.pojo.User;
import org.apache.ibatis.javassist.NotFoundException;

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

    /**
     * 更新用户信息
     * @param userDTO 用户信息
     */
    void updateInfo(UserUpdateUserInfoDTO userDTO);

    /**
     * 更新用户头像
     *
     * @param id 用户Id
     * @param url 用户头像URL地址
     */
    void updateAvatar(Integer id,String url);

    /**
     * 更新用户密码
     * @param id 用户ID
     * @param oldPwd 用户原密码
     * @param newPwd 用户新密码
     * @param rePwd 用户新密码再次确认
     */
    void updatePwd(Integer id,String oldPwd,String newPwd,String rePwd);
}
