package com.itheima.bigeventbackend.mapper;

import com.itheima.bigeventbackend.pojo.Category;
import jakarta.validation.constraints.NotNull;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    void insert(Category category);

    @Select("select * " +
            "from category " +
            "where category_name = #{categoryName} " +
            "and category_alias = #{categoryAlias}")
    Category findByNameAndAlias(@NotNull(message = "文章分类名不可为空") String categoryName, @NotNull(message = "文章分类别名不可为空") String categoryAlias);

    @Select("select * from category")
    List<Category> getAll();

    void update(Category category);

    @Select("select * from category where id = #{id}")
    Category findById(Integer id);

    @Delete("delete from category where id = #{id}")
    void delete(Integer id);
}
