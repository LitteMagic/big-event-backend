package com.itheima.bigeventbackend.mapper;

import com.itheima.bigeventbackend.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ArticleMapper {

    /**
     * 新增文章
     * @param article 文章数据
     */
    public void insert(Article article);
}
