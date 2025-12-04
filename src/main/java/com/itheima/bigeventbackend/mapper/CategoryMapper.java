package com.itheima.bigeventbackend.mapper;

import com.itheima.bigeventbackend.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {

    void insert(Category category);

}
