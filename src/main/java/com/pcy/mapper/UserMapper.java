package com.pcy.mapper;

import com.pcy.pojo.User;
import com.pcy.pojo.User2;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    //1.curd基本操作
    List<User> getAllUser();

    User2 getUserById(int id);

    Integer addUser(User user);

    //万能map，可以不需要直到数据库里的全部字段
    //当然用@Param注解更方便
    Integer addUser2(Map<String,Object> map);

    Integer deleteUserByName(String username);

    Integer UpdateUser(User user);

    //2.模糊查询写法一
    List<User> getUserLike1(String value);

    //2.模糊查询写法二
    List<User> getUserLike2(String value);

    //3.多条件查询,不过要把要查询得许多条件先传进来，即使为空
    User getUserByManyCase(Map<String,Object> map);

    //4.批量增加,动态sql
    Integer addManyUser(@Param("users") List<User> users);

}
