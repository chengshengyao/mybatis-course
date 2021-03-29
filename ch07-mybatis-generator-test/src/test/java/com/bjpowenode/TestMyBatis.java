package com.bjpowenode;

import com.bjpowenode.dao.StudentDao;
import com.bjpowenode.entity.Student;
import com.bjpowenode.utils.MyBatis_Utils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @ProjectName: mybatis-course
 * @Package: com.bjpowenode
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/7 17:38
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
public class TestMyBatis {
    //测试查询方法
    @Test
    public void testSelect() {
        /**
         * 使用MyBatis的动态代理机制，使用sqlSession.getMapper（dao接口）
         * 使用getMapper 获取dao接口对应的实现类对象
         */
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        StudentDao sqlSessionMapper = sqlSession.getMapper(StudentDao.class);
        List<Student> list = sqlSessionMapper.selectStudents();
        list.forEach(student -> System.out.println(student));

    }

    @Test
    public void testInsert() {
        /**
         * 使用MyBatis的动态代理机制，使用sqlSession.getMapper（dao接口）
         * 从而获取 dao接口的实现类对象【这他妈就是动态代理】
         */
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        StudentDao sqlSessionMapper = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(666);
        student.setName("动态代理牛逼");
        student.setEmail("dynamicproxy@niubillty.com");
        student.setAge(6);
        int result = sqlSessionMapper.insertStudents(student);
        System.out.println("使用传统的DAO执行INSERT语句影响数据库表" + result + "条记录");
    }

}
