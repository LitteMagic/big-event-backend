package com.itheima.bigeventbackend.service.impl;


import com.itheima.bigeventbackend.DTO.request.UserUpdateUserInfoDTO;
import com.itheima.bigeventbackend.exception.UserNotFoundException;
import com.itheima.bigeventbackend.mapper.UserMapper;
import com.itheima.bigeventbackend.pojo.User;
import com.itheima.bigeventbackend.service.UserService;
import com.itheima.bigeventbackend.utils.Md5Util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 根据username在User表中查找数据
     *
     * @param username 用户名
     * @return 查找到的用户信息
     */
    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    /**
     * 注册用户
     *
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
    public void updateInfo(UserUpdateUserInfoDTO userDTO) {
//        1.根据UserDTO来生成User
        User user = new User();
        BeanUtils.copyProperties(userDTO, user); //source在前，target在后 userDTO -> user
//        更新数据库中数据的更新时间
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(Integer id, String url) {
        User user = new User();
        user.setId(id);
        user.setUserPic(url);
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updatePwd(Integer id, String oldPwd, String newPwd, String rePwd) {
//        1.检验参数
//        两次密码是否一致
        if (!newPwd.equals(rePwd)) {
            throw new IllegalArgumentException("新密码与确认密码，两者值不同");
        }
//        检查原密码是否正确
        User user = userMapper.findById(id);
        if (user == null) {
            throw new UserNotFoundException("找不到目标用户，用户不存在");
        }

        if (!user.getPassword().equals(Md5Util.getMD5String(oldPwd))) {
            throw new IllegalArgumentException("原密码输入错误");
        }
//        封装用户对象
        User userParam = new User();
        userParam.setId(id);
        userParam.setPassword(Md5Util.getMD5String(newPwd));
        userMapper.update(userParam);
    }
}
