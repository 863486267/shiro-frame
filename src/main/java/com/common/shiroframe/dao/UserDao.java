package com.common.shiroframe.dao;


import com.common.shiroframe.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Mr.John on 2018/11/22 20:57.
 **/

@Mapper
public interface UserDao {
    @Insert("INSERT INTO user (user_name,password,salt) VALUES (#{userName},#{password},#{salt})")
    int add(@Param("userName") String userName,
            @Param("password") String password,
            @Param("salt") String salt);

    @Select("SELECT * FROM user WHERE user_name=#{userName} and password=#{password}")
    UserEntity getOne(@Param("userName") String userName,
                      @Param("password") String password);

    @Select("SELECT * FROM user WHERE user_name=#{userName}")
    UserEntity getUser(@Param("userName") String userName);

//    @Select("SELECT a.role_name FROM role_enum a right join roles b on a.id=b.role left join user c on c.id=b.user_id where c.user_name=#{userName} ")
//    Set<String> getRolesByName(@Param("userName") String userName);

    @Select("SELECT * FROM user ")
    List<UserEntity> getAll();

    @Select("SELECT * FROM user where id=#{id}")
    UserEntity user(@Param("id") int id);

    @Update("UPDATE user SET user_name=#{userName} where id=#{id}")
    int update(@Param("userName") String userName,
               @Param("id") int id);
}
