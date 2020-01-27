package com.pcy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("User")//mybatis类型别名
public class User {
    private int id;
    private String username;
    private String loginname;
    private String pwd;
    private String sex;
}
