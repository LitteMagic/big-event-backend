package com.itheima.bigeventbackend.DTO.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

/**
 * 用户更新用户信息DTO
 */
@Data
public class UserUpdateUserInfoDTO {

    @NotNull
    private Integer id;

    private String username;//用户名

    @NotEmpty //在检测时要求此属性不可为null，并且此属性不能没有值
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;//昵称

    @Email  // 在检测时要求此属性为 Email 格式
    @NotEmpty
    private String email;//邮箱

}
