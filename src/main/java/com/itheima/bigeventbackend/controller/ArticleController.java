package com.itheima.bigeventbackend.controller;

import com.itheima.bigeventbackend.pojo.Article;
import com.itheima.bigeventbackend.DTO.response.Result;
import com.itheima.bigeventbackend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * 获取文章列表
     * @return 文章列表
     */
    @RequestMapping("/list")
    public Result<String> getArticleList(){
        return Result.success("文章数据...");
    }

    /**
     * 添加文章
     * @param article 封装的文章数据
     * @return
     */
    @PostMapping
    public Result<Void> add(Article article){
        articleService.add(article);
        return Result.success();
    }
}
