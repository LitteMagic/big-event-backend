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
    @Update("update user " +
            "set nickname = #{nickname},email=#{email},update_time=#{updateTime} " +
            "where id = #{id}")
    void update(User user);

    /**
     * 更新 user 中的user_pic字段，根据Id查询
     * @param user 封装的user信息
     */
    @Update("update user " +
            "set user_pic = #{userPic},update_time=#{updateTime} " +
            "where id = #{id}")
    void updateAvatar(User user);

    /**
     * 更新user表中的密码password字段
     * @param user 封装的user信息
     */
    @Update("update user " +
            "set password = ${password} " +
            "where id = #{id}")
    void updatePwd(User user);
    
}
