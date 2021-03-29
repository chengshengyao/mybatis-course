package com.powernode;

import com.powernode.entity.Student;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ProjectName: mybatis-course
 * @Package: com.powernode
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/7 11:14
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
public class MyApp {
    public static void main(String[] args) throws IOException {
        //   @-5 .创建使用MtBatis类访问数据库

        //1.定义MyBatis主配置文件的名称，从类路径的根开始【target/classes】
        String config="mybatis.xml";
        //2.读取config所表示的文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(inputStream);
        //5.获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //6.指定执行SQL语句的标识[sql mapper 文件中的namespace]+[.]+[sql mapper 文件中的标签ID值]
        String sqlId="com.powernode.dao.StudentDao.selectStudents";
        //7.通过【6. sqlID】寻找执行SQL语句
        List<Student> list = sqlSession.selectList(sqlId);
        //8.输出结果
        list.forEach(s-> System.out.println(s));
        //9.关闭
        sqlSession.close();

    }
}
