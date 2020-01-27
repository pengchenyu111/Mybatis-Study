package com.pcy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * 一对多
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("BillsType2")
public class BillsType2 {
    private int id;
    private String name;
    private List<Bills2> bills2s;
}
