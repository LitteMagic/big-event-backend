package com.itheima.bigeventbackend.service;

import com.itheima.bigeventbackend.DTO.request.CategoryAddDTO;

public interface CategoryService {
    /**
     * 添加文章
     * @param categoryAddDTO 添加文章封装参数信息
     */
    void add(CategoryAddDTO categoryAddDTO);
}
