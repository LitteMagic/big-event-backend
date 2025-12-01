package com.itheima.bigeventbackend.controller;

import com.itheima.bigeventbackend.constant.APIResponseConstants;
import com.itheima.bigeventbackend.pojo.LoginUser;
import com.itheima.bigeventbackend.pojo.Result;
import com.itheima.bigeventbackend.pojo.User;
import com.itheima.bigeventbackend.service.UserService;
import com.itheima.bigeventbackend.utils.JwtUtil;
import com.itheima.bigeventbackend.utils.Md5Util;
import com.itheima.bigeventbackend.utils.UserContextUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 用户注册方法
     * @param username 用户名
     * @param password 密码
     * @return 方法完成反馈
     */
    @PostMapping("/register")
    public Result<Void> register(@Pattern(regexp = "^\\S{5,16}$") String username,
                           @Pattern(regexp = "^\\S{5,16}$") String password){
//        1.检查有无重名user
        User user = userService.findByName(username);
        if (user!=null){
//            返回用户占用信息
            return Result.error(APIResponseConstants.MESSAGE_ERROR_USER_REGISTER_USER_TOKEN);
        }
//        2.注册用户
        userService.register(username,password);
//        返回注册成功信息
        return Result.success();

    }

    /**
     * 用户登录方法
     * @param username 用户名
     * @param password 密码
     * @return 完成返回
     */
    @RequestMapping("/login")
    public Result<String> login(String username,String password){
//        1.检查用户名是否正确
        User user = userService.findByName(username);
        if (user == null){
//            返回用户名不存在错误
            return  Result.error(APIResponseConstants.MESSAGE_ERROR_USER_LOGIN_USER_DOES_NOT_EXISTS);
        }
//        2.检查密码是否正确
//        使用MD5加密，判断密码是否正确
        if (!Md5Util.checkPassword(password,user.getPassword())){
//            密码不匹配，返回错误信息
            return Result.error(APIResponseConstants.MESSAGE_ERROR_USER_LOGIN_PASSWORD_ERROR);
        }

//        3.生成JWT令牌并返回
        Map<String,Object> claims = new HashMap<>();
        claims.put("username",username);
        String JWTToken = JwtUtil.genToken(claims);
        return Result.success(JWTToken);
    }

    /**
     * 获取用户信息（根据ThreadLocal中的用户名）
     * @return 用户信息
     */
    @RequestMapping("/userInfo")
    public Result<User> userInfo(){
        LoginUser loginUser = UserContextUtil.get();
        String loginUsername = loginUser.getUsername();
        User user = userService.findByName(loginUsername);
        if (user == null){
            return Result.error(APIResponseConstants.MESSAGE_ERROR_USER_LOGIN_USER_DOES_NOT_EXISTS);
        }else {
            return Result.success(user);
        }
    }
}
