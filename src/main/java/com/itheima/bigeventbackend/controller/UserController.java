package com.itheima.bigeventbackend.controller;

import com.itheima.bigeventbackend.DTO.request.*;
import com.itheima.bigeventbackend.constant.APIResponseConstants;
import com.itheima.bigeventbackend.pojo.LoginUser;
import com.itheima.bigeventbackend.DTO.response.Result;
import com.itheima.bigeventbackend.pojo.User;
import com.itheima.bigeventbackend.service.UserService;
import com.itheima.bigeventbackend.utils.JwtUtil;
import com.itheima.bigeventbackend.utils.Md5Util;
import com.itheima.bigeventbackend.utils.UserContextUtil;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
     * @param userRegisterDTO 请求参数
     * @return 方法完成反馈
     */
    @PostMapping("/register")
    public Result<Void> register(@Validated UserRegisterDTO userRegisterDTO){
//        1.检查有无重名user
        User user = userService.findByName(userRegisterDTO.getUsername());
        if (user!=null){
//            返回用户占用信息
            return Result.error(APIResponseConstants.MESSAGE_ERROR_USER_REGISTER_USER_TOKEN);
        }
//        2.注册用户
        userService.register(userRegisterDTO.getUsername(),userRegisterDTO.getPassword());
//        返回注册成功信息
        return Result.success();

    }

    /**
     * 用户登录方法
     * @param userLoginDTO 用户登录请求DTO
     * @return 完成返回
     */
    @PostMapping("/login")
    public Result<String> login(@Validated UserLoginDTO userLoginDTO){
//        1.检查用户名是否正确
        User user = userService.findByName(userLoginDTO.getUsername());
        if (user == null){
//            返回用户名不存在错误
            return  Result.error(APIResponseConstants.MESSAGE_ERROR_USER_LOGIN_USER_DOES_NOT_EXISTS);
        }
//        2.检查密码是否正确
//        使用MD5加密，判断密码是否正确
        if (!Md5Util.checkPassword(userLoginDTO.getPassword(),user.getPassword())){
//            密码不匹配，返回错误信息
            return Result.error(APIResponseConstants.MESSAGE_ERROR_USER_LOGIN_PASSWORD_ERROR);
        }

//        3.生成JWT令牌并返回
        Map<String,Object> claims = new HashMap<>();
        claims.put("username",user.getUsername());
        claims.put("id",user.getId());
        String JWTToken = JwtUtil.genToken(claims);
        return Result.success(JWTToken);
    }

    /**
     * 获取用户信息（根据ThreadLocal中的用户名）
     * @return 用户信息
     */
    @GetMapping("/userInfo")
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

    /**
     * 更新用户信息
     * @param UserUpdateUserInfoDTO 用户信息
     * @return
     */
    @PutMapping("/update")
    public Result<Void> updateUSerInfo(@RequestBody @Validated UserUpdateUserInfoDTO UserUpdateUserInfoDTO){
        userService.updateInfo(UserUpdateUserInfoDTO);
        return Result.success();
    }

    /**
     * 更新用户头像
     * @param updateAvatarDTO 用户头像地址信息
     * @return
     */
    @PatchMapping("/updateAvatar")
    public  Result<Void> updateAvatar(@RequestBody @Validated UserUpdateAvatarDTO updateAvatarDTO){
        //交由Service处理
        Integer userId = UserContextUtil.get().getId(); //当前登录用户 Id
        userService.updateAvatar(userId,updateAvatarDTO.getUrl());

        return Result.success();
    }

    /**
     * 更新用户密码
     * @param userUpdatePwdDTO 用户更新密码请求
     * @return
     */
    @PatchMapping("/updatePwd")
    public  Result<Void> updatePwd(@RequestBody @Validated UserUpdatePwdDTO userUpdatePwdDTO){
        Integer userId = UserContextUtil.get().getId();
        userService.updatePwd(userId,
                userUpdatePwdDTO.getOldPwd(),
                userUpdatePwdDTO.getNewPwd(),
                userUpdatePwdDTO.getRePwd());
        return Result.success();

    }

}
