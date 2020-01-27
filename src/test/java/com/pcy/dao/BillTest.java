package com.pcy.dao;

import com.pcy.mapper.BillMapper;
import com.pcy.mapper.BillType2Mapper;
import com.pcy.mapper.BillTypeMapper;
import com.pcy.pojo.BillType;
import com.pcy.pojo.Bills;
import com.pcy.pojo.BillsType2;
import com.pcy.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class BillTest {

    @Test
    public void getAllBillType(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BillTypeMapper mapper = sqlSession.getMapper(BillTypeMapper.class);
        List<BillType> allBillType = mapper.getAllBillType();
        for (BillType billType : allBillType) {
            System.out.println(billType);
        }
        sqlSession.close();
    }

    @Test
    public void getBillTypeById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BillTypeMapper mapper = sqlSession.getMapper(BillTypeMapper.class);
        BillType billType = mapper.getBillTypeById(1);
        System.out.println(billType);
        sqlSession.close();
    }

    /**
     * 多对一：通过结果连接查询
     */
    @Test
    public void getBills2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        List<Bills> billsList = mapper.getAllBills1();
        for (Bills bills : billsList) {
            System.out.println(bills);
        }
        sqlSession.close();
    }

    /**
     * 多对一：通过子查询
     */
    @Test
    public void getBills3(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        List<Bills> billsList = mapper.getAllBills2();
        for (Bills bills : billsList) {
            System.out.println(bills);
        }
        sqlSession.close();
    }

    /**
     * 一对多：通过结果连接查询
     */
    @Test
    public void getBillTypeById1(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BillType2Mapper mapper = sqlSession.getMapper(BillType2Mapper.class);
        BillsType2 billsType2 = mapper.getBillTypeById1(1);
        System.out.println(billsType2);
        sqlSession.close();
    }

    /**
     * 一对多：通过子查询
     */
    @Test
    public void getBillTypeById2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BillType2Mapper mapper = sqlSession.getMapper(BillType2Mapper.class);
        BillsType2 billsType2 = mapper.getBillTypeById2(1);
        System.out.println(billsType2);
        sqlSession.close();
    }
}
