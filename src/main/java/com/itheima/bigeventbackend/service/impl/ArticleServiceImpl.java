package com.itheima.bigeventbackend.service.impl;

import com.itheima.bigeventbackend.mapper.ArticleMapper;
import com.itheima.bigeventbackend.pojo.Article;
import com.itheima.bigeventbackend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        articleMapper.add(article);
    }
}
