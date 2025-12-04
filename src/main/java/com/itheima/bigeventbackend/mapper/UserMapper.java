package com.itheima.bigeventbackend.mapper;

import com.itheima.bigeventbackend.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    /**
     * 根据username在User表中查找数据
     * @param username 用户名
     * @return 查找到的用户信息
     */
    @Select("select * from user where username = #{username}")
    User findByName(String username);

    /**
     *
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    /**
     * 在user表中添加数据
     * @param user 添加的user数据
     */
    @Insert("insert into user(username, password, create_time, update_time)" +
            "value (#{username},#{password},now(),now())")
    void add(User user);

    /**
     * 在 user 中更新用户的基本信息
     * @param user 封装的用心信息
     */
    void update(User user);


}
