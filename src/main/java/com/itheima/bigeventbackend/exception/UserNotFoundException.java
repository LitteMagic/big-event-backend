package com.itheima.bigeventbackend.exception;

/**
 * 在数据库中没有找到用户的异常
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
