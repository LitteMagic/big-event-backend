package com.itheima.bigeventbackend.DTO.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 用户修改密码请求DTO
 */
@Data
public class UserUpdatePwdDTO {
    @NotBlank(message = "原密码不能为空")
    @JsonProperty("old_pwd")
    private String oldPwd;

    @NotBlank(message = "新密码不能为空")
    @JsonProperty("new_pwd")
    private String newPwd;

    @NotBlank(message = "确认密码不能为空")
    @JsonProperty("re_pwd")
    private String rePwd;
}
