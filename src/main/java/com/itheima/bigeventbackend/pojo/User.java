package com.itheima.bigeventbackend.pojo;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull    //在检测时，要求此属性不可为null
    private Integer id;//主键ID
    private String username;//用户名

    @JsonIgnore // 被注释字段在被转换为JSON格式时，会被忽略
    private String password;//密码

    @NotEmpty //在检测时要求此属性不可为null，并且此属性不能没有值
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;//昵称

    @Email  // 在检测时要求此属性为 Email 格式
    @NotEmpty
    private String email;//邮箱
    private String userPic;//用户头像地址
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
