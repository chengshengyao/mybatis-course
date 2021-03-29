package com.powernode;

import com.powernode.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ProjectName: mybatis-course
 * @Package: com.powernode
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/7 14:45
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
public class TestMyBatis {
    @Test
    public void testInsert() throws IOException {
        //   @-5 .创建使用MtBatis类访问数据库

        //1.定义MyBatis主配置文件的名称，从类路径的根开始【target/classes】
        String config="mybatis.xml";
        //2.读取config所表示的文件
        InputStream inputStream = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(inputStream);
        //5.获取SqlSession对象 【此处开启事务自动提交机制】
        SqlSession sqlSession = factory.openSession(true);
        //6.指定执行SQL语句的标识[sql mapper 文件中的namespace]+[.]+[sql mapper 文件中的标签ID值]
        String sqlId="com.bjpowernode.dao.StudentDao.insertStudent";
        //7.通过【6. sqlID】寻找执行SQL语句
        Student student = new Student();
        student.setId(1004);
        student.setName("大飞");
        student.setEmail("dafei@sb.com");
        student.setAge(44);
        int result = sqlSession.insert(sqlId,student);
        //!!!注意！！！MyBatis默认不会在INSERT/UPDATE/DELETE后自动提交事务【此步骤进行手动提交】
        //sqlSession.commit();
        //8.输出结果
        System.out.println("使用MyBatis框架技术执行INSERT语句，影响了ssm数据库的student表中"+result+"行数据");
        //9.关闭
        sqlSession.close();
    }

}
