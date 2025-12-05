package com.itheima.bigeventbackend.DTO.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryUpdateInfoDTO {
    @NotBlank(message = "文章分类id 不可为空")
    private Integer id;

    @NotBlank(message = "文章分类名称不可为空")
    private String categoryName;

    @NotBlank(message = "文章分类别名不可为空")
    private String categoryAlias;

}
