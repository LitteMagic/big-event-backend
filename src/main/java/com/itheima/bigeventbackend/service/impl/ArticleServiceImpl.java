package com.itheima.bigeventbackend.service.impl;

import com.itheima.bigeventbackend.DTO.request.ArticleAddDTO;
import com.itheima.bigeventbackend.exception.CategoryDontExistException;
import com.itheima.bigeventbackend.mapper.ArticleMapper;
import com.itheima.bigeventbackend.mapper.CategoryMapper;
import com.itheima.bigeventbackend.pojo.Article;
import com.itheima.bigeventbackend.service.ArticleService;
import com.itheima.bigeventbackend.utils.UserContextUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public void add(ArticleAddDTO articleAddDTO) {
//        1.检查文章分类是否存在
        Integer categoryId = articleAddDTO.getCategoryId();
        if (categoryMapper.findById(categoryId) == null) {
            throw new CategoryDontExistException("文章分类不存在!!!");
        }
//        2.封装数据
        Article article = new Article();
        BeanUtils.copyProperties(articleAddDTO,article);
//        更新article数据
        article.setUpdateTime(LocalDateTime.now());
        article.setCreateTime(LocalDateTime.now());
        Integer userId = UserContextUtil.get().getId();
        article.setCreateUser(userId);

        articleMapper.insert(article);
    }
}
