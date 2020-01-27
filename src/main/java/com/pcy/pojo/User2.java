package com.pcy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用来演示resultMap的作用
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User2 {
    private int id;
    private String username;
    private String account;
    private String password;
    private String sex;
}
