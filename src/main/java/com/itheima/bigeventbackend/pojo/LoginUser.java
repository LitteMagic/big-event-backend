package com.itheima.bigeventbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 存储用户信息，用于
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {

    private String username;

    public  LoginUser(Map<String, Object> claims)
    {
        this.username = (String) claims.get("username");
    }
}
