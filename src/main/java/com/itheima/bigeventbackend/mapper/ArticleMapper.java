package com.itheima.bigeventbackend.mapper;

import com.itheima.bigeventbackend.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ArticleMapper {

    @Insert("")
    public void add(Article article);
}
