package com.pcy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * 一对多
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("Bills2")
public class Bills2 {
    private int id;
    private String title;
    private String billtime;
    private int typeid;
    private double price;
    private String remark;
}
