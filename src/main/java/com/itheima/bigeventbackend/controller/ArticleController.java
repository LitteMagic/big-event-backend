package com.itheima.bigeventbackend.controller;

import com.itheima.bigeventbackend.pojo.Article;
import com.itheima.bigeventbackend.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    /**
     * 获取文章列表
     * @return 文章列表
     */
    @RequestMapping("/list")
    public Result<String> getArticleList(){
        return Result.success("文章数据...");
    }
}
