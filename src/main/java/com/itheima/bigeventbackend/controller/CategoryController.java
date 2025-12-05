package com.itheima.bigeventbackend.controller;

import com.itheima.bigeventbackend.DTO.request.CategoryAddDTO;
import com.itheima.bigeventbackend.DTO.request.CategoryDetailDTO;
import com.itheima.bigeventbackend.DTO.request.CategoryUpdateInfoDTO;
import com.itheima.bigeventbackend.DTO.response.CategoryDetailVO;
import com.itheima.bigeventbackend.DTO.response.Result;
import com.itheima.bigeventbackend.pojo.Category;
import com.itheima.bigeventbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService ;

    /**
     * 新增文章分类
     * @param categoryAddDTO 文章分类封装数据
     * @return 运行结果
     */
    @PostMapping
    public Result<Void> add(@RequestBody CategoryAddDTO categoryAddDTO){
        categoryService.add(categoryAddDTO);
        return Result.success();
    }

    /**
     * 获取所有文章分类信息
     * @return 所有文章信息
     */
    @GetMapping
    public Result<List<Category>> getAll(){
       List<Category> categories= categoryService.getAll();
       return Result.success(categories);
    }

    @PutMapping
    public Result<Void> update(@RequestBody CategoryUpdateInfoDTO categoryUpdateInfoDTO){
        categoryService.update(categoryUpdateInfoDTO);
        return Result.success();
    }

    @GetMapping("/detail")
    public Result<CategoryDetailVO> detail(CategoryDetailDTO categoryDetailDTO){
        CategoryDetailVO categoryDetailVO = categoryService.findById(categoryDetailDTO.getId());
        return Result.success(categoryDetailVO);
    }

    @DeleteMapping
    public Result<Void> delete(CategoryDetailDTO categoryDetailDTO){
        categoryService.delete(categoryDetailDTO.getId());
        return Result.success();
    }

}
