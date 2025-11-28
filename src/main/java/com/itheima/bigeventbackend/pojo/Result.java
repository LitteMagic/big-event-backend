package com.itheima.bigeventbackend.pojo;


import com.itheima.bigeventbackend.constant.APIResponseConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//统一响应结果
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;//业务状态码  0-成功  1-失败
    private String message;//提示信息
    private T data;//响应数据

    //快速返回操作成功响应结果(带响应数据)
    public static <E> Result<E> success(E data) {
        return new Result<>(APIResponseConstants.CODE_SUCCESS , APIResponseConstants.MESSAGE_SUCCESS, data);
    }

    //快速返回操作成功响应结果
    public static Result<Void> success() {
        return new Result<>(APIResponseConstants.CODE_SUCCESS, APIResponseConstants.MESSAGE_SUCCESS, null);
    }

    public static <T> Result<T> error(String message) {
        return new Result<>(APIResponseConstants.CODE_FAILURE, message, null);
    }
}
