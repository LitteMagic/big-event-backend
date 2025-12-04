package com.itheima.bigeventbackend.service.impl;

import com.itheima.bigeventbackend.DTO.request.CategoryAddDTO;
import com.itheima.bigeventbackend.mapper.CategoryMapper;
import com.itheima.bigeventbackend.pojo.Category;
import com.itheima.bigeventbackend.service.CategoryService;
import com.itheima.bigeventbackend.utils.UserContextUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public void add(CategoryAddDTO categoryAddDTO) {
//        1.将DTO中的数据 赋值到category中
        Category category = new Category();
        BeanUtils.copyProperties(categoryAddDTO,category);
//        2.编辑category中的数据
        Integer createUserId = UserContextUtil.get().getId(); //操作用户ID
        category.setCreateUser(createUserId);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());

        categoryMapper.insert(category);

    }
}
