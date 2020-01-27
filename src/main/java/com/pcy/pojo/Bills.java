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
@Alias("Bill")
public class Bills {
    private int id;
    private String title;
    private String billtime;
    private BillType billType;
    private double price;
    private String remark;
}
