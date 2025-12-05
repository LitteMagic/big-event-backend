package com.itheima.bigeventbackend.exception;

/**
 * 用户未登录错误
 */
public class UserNotLoginException extends RuntimeException{
    public UserNotLoginException(String message){
        super(message);
    }
}
