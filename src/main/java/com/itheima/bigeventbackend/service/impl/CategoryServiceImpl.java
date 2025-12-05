package com.itheima.bigeventbackend.service.impl;

import com.itheima.bigeventbackend.DTO.request.CategoryAddDTO;
import com.itheima.bigeventbackend.DTO.request.CategoryUpdateInfoDTO;
import com.itheima.bigeventbackend.DTO.response.CategoryDetailVO;
import com.itheima.bigeventbackend.exception.CategoryAlreadyExistException;
import com.itheima.bigeventbackend.exception.UserNotFoundException;
import com.itheima.bigeventbackend.exception.UserNotLoginException;
import com.itheima.bigeventbackend.mapper.CategoryMapper;
import com.itheima.bigeventbackend.pojo.Category;
import com.itheima.bigeventbackend.service.CategoryService;
import com.itheima.bigeventbackend.utils.UserContextUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public void add(CategoryAddDTO categoryAddDTO) {
//        1.数据检测，如果数据库中有重名数据，那么就不进行插入
        Category categoryInDB =
                categoryMapper.findByNameAndAlias(categoryAddDTO.getCategoryName()
                        , categoryAddDTO.getCategoryAlias());
        if (categoryInDB != null) {
            throw new CategoryAlreadyExistException("文章分类已存在");
        }
//        2.将DTO中的数据 赋值到category中
        Category category = new Category();
        BeanUtils.copyProperties(categoryAddDTO, category);
//        3.编辑category中的数据
        Integer createUserId = UserContextUtil.get().getId(); //操作用户ID
        category.setCreateUser(createUserId);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());

        categoryMapper.insert(category);

    }

    @Override
    public List<Category> getAll() {
        return categoryMapper.getAll();
    }

    @Override
    public void update(CategoryUpdateInfoDTO categoryUpdateInfoDTO) {
//        1.检验当前用户是否登录
        Integer currentUserId = UserContextUtil.get().getId();
        if (currentUserId == null) {
            throw new UserNotLoginException("当前用户未登录，或者登录时效过期");
        }
//        2.封装信息，进行更新
        Category category = new Category();
        BeanUtils.copyProperties(categoryUpdateInfoDTO, category);
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.update(category);

    }

    @Override
    public CategoryDetailVO findById(Integer id) {
//        查询数据
        Category category = categoryMapper.findById(id);
//        将 pojo 转换为 vo
        CategoryDetailVO categoryDetailVO = new CategoryDetailVO();
        BeanUtils.copyProperties(category, categoryDetailVO);
        return categoryDetailVO;
    }

    @Override
    public void delete(Integer id) {
        categoryMapper.delete(id);
    }
}
