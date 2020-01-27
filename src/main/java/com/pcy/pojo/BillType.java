package com.pcy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * 多对一
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("BillType")
public class BillType {
    private int id;
    private String name;
}
