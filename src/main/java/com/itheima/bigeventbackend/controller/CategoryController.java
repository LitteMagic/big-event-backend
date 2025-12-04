package com.itheima.bigeventbackend.controller;

import com.itheima.bigeventbackend.DTO.request.CategoryAddDTO;
import com.itheima.bigeventbackend.DTO.response.Result;
import com.itheima.bigeventbackend.pojo.Category;
import com.itheima.bigeventbackend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService ;

    @PostMapping
    public Result<Void> add(@RequestBody CategoryAddDTO categoryAddDTO){
        categoryService.add(categoryAddDTO);
        return Result.success();
    }
}
