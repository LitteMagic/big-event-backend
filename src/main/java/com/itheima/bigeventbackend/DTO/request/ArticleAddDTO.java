package com.itheima.bigeventbackend.DTO.request;

import com.itheima.bigeventbackend.anno.StateValdate;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 新增文章DTO
 */
@Data
public class ArticleAddDTO {
    @NotEmpty
    private String title;

    @NotEmpty
    private String content;

    @NotEmpty
    private String coverImg;

    @NotEmpty
    @StateValdate
    private String state;

    @NotNull
    private Integer categoryId;
}
