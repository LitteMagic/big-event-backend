package com.itheima.bigeventbackend.exception;

import com.itheima.bigeventbackend.constant.APIResponseConstants;
import com.itheima.bigeventbackend.DTO.response.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 */
@RestControllerAdvice
public class GolbalExceptior {

    @ExceptionHandler(Exception.class)
    public Result<Void> handle(Exception exception){
        exception.printStackTrace();
        return Result.error(
                ( StringUtils.hasLength(exception.getMessage() ) ) ?
                        exception.getMessage() : APIResponseConstants.MESSAGE_FAILURE);
    }

}
