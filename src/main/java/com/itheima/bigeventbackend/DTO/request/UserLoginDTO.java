package com.itheima.bigeventbackend.DTO.request;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

/**
 * 用户登录请求DTO
 */
@Data
public class UserLoginDTO {

    @Pattern(regexp = "^\\S{5,16}$")
    private String username;

    @Pattern(regexp = "^\\S{5,16}$")
    private String password;
}
