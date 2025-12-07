package com.itheima.bigeventbackend.controller;

import com.itheima.bigeventbackend.DTO.request.CategoryAddDTO;
import com.itheima.bigeventbackend.DTO.request.CategoryDeleteDTO;
import com.itheima.bigeventbackend.DTO.request.CategoryDetailDTO;
import com.itheima.bigeventbackend.DTO.request.CategoryUpdateInfoDTO;
import com.itheima.bigeventbackend.DTO.response.CategoryDetailVO;
import com.itheima.bigeventbackend.DTO.response.Result;
import com.itheima.bigeventbackend.pojo.Category;
import com.itheima.bigeventbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    public Result<Void> add(@RequestBody @Validated CategoryAddDTO categoryAddDTO){
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

    /**
     * 更新文章分类
     * @param categoryUpdateInfoDTO
     * @return
     */
    @PutMapping
    public Result<Void> update(@RequestBody @Validated CategoryUpdateInfoDTO categoryUpdateInfoDTO){
        categoryService.update(categoryUpdateInfoDTO);
        return Result.success();
    }

    /**
     * 查询文章分类详细信息（单个）
     * @param categoryDetailDTO 内含文章分类ID
     * @return 操作结果
     */
    @GetMapping("/detail")
    public Result<CategoryDetailVO> detail(@Validated CategoryDetailDTO categoryDetailDTO){
        CategoryDetailVO categoryDetailVO = categoryService.findById(categoryDetailDTO.getId());
        return Result.success(categoryDetailVO);
    }

    /**
     * 删除文章分类
     * @param categoryDeleteDTO 内含文章分类ID
     * @return 操作结果
     */
    @DeleteMapping
    public Result<Void> delete(@Validated CategoryDeleteDTO categoryDeleteDTO){
        categoryService.delete(categoryDeleteDTO.getId());
        return Result.success();
    }

}
