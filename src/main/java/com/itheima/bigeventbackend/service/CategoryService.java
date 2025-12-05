package com.itheima.bigeventbackend.service;

import com.itheima.bigeventbackend.DTO.request.CategoryAddDTO;
import com.itheima.bigeventbackend.DTO.request.CategoryUpdateInfoDTO;
import com.itheima.bigeventbackend.DTO.response.CategoryDetailVO;
import com.itheima.bigeventbackend.pojo.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 添加文章
     * @param categoryAddDTO 添加文章封装参数信息
     */
    void add(CategoryAddDTO categoryAddDTO);

    /**
     * 获取文章列表
     * @return 文章列表 list
     */
    List<Category> getAll();

    /**
     * 更新文章数据
     * @param categoryUpdateInfoDTO 文章分类信息
     */
    void update(CategoryUpdateInfoDTO categoryUpdateInfoDTO);

    /**
     * 根据文章分类Id 查询
     * @param id 文章 ID
     * @return 文章信息 VO
     */
    CategoryDetailVO findById(Integer id);

    /**
     * 根据文章分类删除文章
     * @param id 文章 id
     */
    void delete(Integer id);
}
