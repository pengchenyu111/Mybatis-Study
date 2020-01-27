package com.pcy.mapper;

import com.pcy.pojo.BillType;

import java.util.List;

public interface BillTypeMapper {

    List<BillType> getAllBillType();

    BillType getBillTypeById(int id);
}
