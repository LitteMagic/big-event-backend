package com.itheima.bigeventbackend.utils;

import com.itheima.bigeventbackend.pojo.LoginUser;

/**
 * ThreadLocal工具类，用于记录线程信息
 */
public class UserContextUtil {
//    一个线程中可以有多个ThreadLocal来存储信息，一个ThreadLocal中存放一个对象
    private static final ThreadLocal<LoginUser> CURRENT_USER_INFO = new ThreadLocal<>();

    public static void set(LoginUser loginUser) {
        CURRENT_USER_INFO.set(loginUser);
    }

    public static LoginUser get() {
        return CURRENT_USER_INFO.get();
    }

    public static void remove() {
        CURRENT_USER_INFO.remove();
    }
}
