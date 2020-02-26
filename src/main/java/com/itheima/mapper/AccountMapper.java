package com.itheima.mapper;

import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AccountMapper {
    @Select("select * from account where uid = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "sum", column = "sum"),
            @Result(property = "uid", column = "uid"),
            //根据账户信息查询用户信息(考察动态sql,关联查询)
            @Result(
                    property = "user", column = "uid", javaType = User.class, one = @One(select = "com.itheima.mapper.UserMapper.findUserByid")
            )
    })
    public List<Account> findAllAccount(int id);

    @Delete("delete from account where uid = #{uid}")
    public void deleteAccounts(String uid);
}
