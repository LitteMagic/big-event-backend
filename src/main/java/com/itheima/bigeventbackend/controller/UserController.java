package com.itheima.bigeventbackend.controller;

import com.itheima.bigeventbackend.pojo.Result;
import com.itheima.bigeventbackend.pojo.User;
import com.itheima.bigeventbackend.service.UserService;
import com.itheima.bigeventbackend.service.impl.UserServiceImpl;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username,
                           @Pattern(regexp = "^\\S{5,16}$") String password){
//        1.检查有无重名user
        User user = userService.findByName(username);
        if (user!=null){
            return Result.error("用户名已被占用");
        }

        userService.register(username,password);
        return Result.success();

    }
}
