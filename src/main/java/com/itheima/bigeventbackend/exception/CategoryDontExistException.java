package com.itheima.bigeventbackend.exception;

/**
 * 文章分类不存在错误
 */
public class CategoryDontExistException extends RuntimeException{
    public CategoryDontExistException(String message){super(message);}
}
