package com.itheima.bigeventbackend.service;

import com.itheima.bigeventbackend.DTO.request.ArticleAddDTO;
import com.itheima.bigeventbackend.pojo.Article;

public interface ArticleService {
    /**
     * 新增文章
     * @param articleAddDTO 文章数据
     */
    void add(ArticleAddDTO articleAddDTO);
}
