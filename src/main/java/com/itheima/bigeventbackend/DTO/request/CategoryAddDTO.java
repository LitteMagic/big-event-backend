package com.itheima.bigeventbackend.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 新增分类请求DTO
 */
@Data
public class CategoryAddDTO {

    @NotBlank(message = "文章分类名不可为空")
    private String categoryName;

    @NotBlank(message = "文章分类别名不可为空")
    private String categoryAlias;
}
