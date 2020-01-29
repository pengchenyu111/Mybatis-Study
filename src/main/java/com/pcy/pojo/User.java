package com.pcy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("User")//mybatis类型别名
public class User implements Serializable {
    private int id;
    private String username;
    private String loginname;
    private String pwd;
    private String sex;
}
