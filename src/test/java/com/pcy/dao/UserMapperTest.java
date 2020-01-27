package com.pcy.dao;

import com.pcy.mapper.UserMapper;
import com.pcy.pojo.User;
import com.pcy.pojo.User2;
import com.pcy.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void getAllUserTest(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        //方式1：通过getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = userMapper.getAllUser();
        for (User user : allUser) {
            System.out.println(user);
        }

        //方式2：通过getMapper
        List<User> list = sqlSession.selectList("com.pcy.mapper.UserMapper.getAllUser");
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getOneUserTest(){
        logger.info("开始查找一个用户");
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User2 user1 = userMapper.getUserById(1);
        System.out.println(user1);
        sqlSession.close();
    }

    //注意增删改都要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(4);
        user.setUsername("无视对方");
        user.setLoginname("123456");
        user.setPwd("123");
        user.setSex("男");
        Integer rows = userMapper.addUser(user);
        System.out.println("受影响的行数为：" + rows);
        List<User> allUser = userMapper.getAllUser();
        for (User user1 : allUser) {
            System.out.println(user1);
        }
        sqlSession.commit();//这一句不写的或不会插入数据库
        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("userid",5);//要跟sql中的#{}中的内容对应即可
        map.put("password","123");
        Integer rows = userMapper.addUser2(map);
        System.out.println("受影响的行数为：" + rows);
        List<User> allUser = userMapper.getAllUser();
        for (User user1 : allUser) {
            System.out.println(user1);
        }
        sqlSession.commit();//这一句不写的或不会插入数据库
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(4);
        user.setUsername("对方");
        Integer rows = userMapper.UpdateUser(user);
        System.out.println("受影响的行数为：" + rows);
        List<User> allUser = userMapper.getAllUser();
        for (User user1 : allUser) {
            System.out.println(user1);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer rows = userMapper.deleteUserByName("对方");
        System.out.println("受影响的行数为：" + rows);
        List<User> allUser = userMapper.getAllUser();
        for (User user1 : allUser) {
            System.out.println(user1);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 模糊查询法一
     */
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //List<User> users = userMapper.getUserLike1("小");查不到，要加通配符
        //List<User> users = userMapper.getUserLike1("%小%");这样又容易导致sql注入问题，所以应该在sql语句中控制
        List<User> users = userMapper.getUserLike1("小");
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    /**
     * 模糊查询法二
     */
    @Test
    public void getUserLike2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getUserLike2("小");
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    /**
     * 多条件查询
     */
    @Test
    public void getUserByManyCase(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id",5);
        map.put("username","小李");
        map.put("loginname","");
        map.put("pwd","");
        map.put("sex","");
        User user = userMapper.getUserByManyCase(map);
        System.out.println(user);
        sqlSession.close();
    }

    /**
     * 动态sql  foreach
     */
    @Test
    public void addManyUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user  = new User(6,"张三","zhangsan3","123","男");
        User user2  = new User(7,"张四","zhangsan4","123","男");
        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user2);
        userMapper.addManyUser(users);
        List<User> allUser = userMapper.getAllUser();
        for (User one : allUser) {
            System.out.println(one);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
