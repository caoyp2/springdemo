package com.ittest.springdemo.mybatis.mapper;

import com.ittest.springdemo.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> getUsers(User user);

    User getUserById(Integer id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUserById(Integer id);

    User getUserByNameAndPwd(@Param("username") String username,
                             @Param("password") String password);

    int modifyPassword(@Param("username") String username,
                       @Param("password") String password);

}
