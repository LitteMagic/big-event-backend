package com.itheima.bigeventbackend.exception;

/**
 * 文章分类已经存在错误
 */
public class CategoryAlreadyExistException extends RuntimeException{
    public CategoryAlreadyExistException(String message){
        super(message);
    }
}
