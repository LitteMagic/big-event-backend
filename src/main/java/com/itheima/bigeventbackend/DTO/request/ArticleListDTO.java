package com.itheima.bigeventbackend.DTO.request;

import com.itheima.bigeventbackend.anno.StateValdate;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ArticleListDTO {
    @NotNull
    private Integer pageNum;

    @NotNull
    private Integer pageSize;

    private Integer categoryId;

    @StateValdate
    private String state;
}
