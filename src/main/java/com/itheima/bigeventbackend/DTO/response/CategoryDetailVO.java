package com.itheima.bigeventbackend.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDetailVO {
    private Integer id;//主键ID
    private String categoryName;//分类名称
    private String categoryAlias;//分类别名
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
