package com.itheima.bigeventbackend.mapper;

import com.itheima.bigeventbackend.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
     * 在user表中添加数据
     * @param user 添加的user数据
     */
    @Insert("insert into user(username, password, create_time, update_time)" +
            "value (#{username},#{password},now(),now())")
    void add(User user);
}
