package com.itheima.mapper;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from user where username = #{username} and password = #{password}")
    public User login(@Param("username") String username, @Param("password") String password);
    // 2.2完成页面数据的展示从数据库中查询
    @Select("select * from user")
    List<User> findAllUser();
    //2.3根据用户名查询用户数据
    @Select("select * from user where username = #{username}")
    List<User> findUserByName(String username);

    @Select("select * from user where id = #{id}")
    List<User> findUserByid(String id);

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "birthday", column = "birthday"),
            //2.4根据用户信息(user_id)查询关联的账户信息(考察动态sql,关联查询)
            @Result(
                    property = "accountList", javaType = List.class, column = "id", many = @Many(select = "com.itheima.mapper.AccountMapper.findAllAccount")
            )
    })
    User findUserAndAccount(String id);

    @Delete("delete from user where id = #{id}")
    void deleteUser(String id);

    @Update("update user set username= #{username},password = #{password},birthday=#{birthday} where id = #{id}")
    void modifyUser(User user);
}
