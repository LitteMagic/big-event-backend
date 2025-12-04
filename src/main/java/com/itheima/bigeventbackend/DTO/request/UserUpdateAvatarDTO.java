package com.itheima.bigeventbackend.DTO.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * 用户更新头像请求DTO
 */
@Data
public class UserUpdateAvatarDTO {
    private String url;
}
