package com.itheima.bigeventbackend.DTO.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryAddDTO {

    @NotNull(message = "文章分类名不可为空")
    private String categoryName;

    @NotNull(message = "文章分类别名不可为空")
    private String categoryAlias;
}
