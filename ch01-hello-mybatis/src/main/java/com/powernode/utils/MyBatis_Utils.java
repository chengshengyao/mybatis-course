package com.powernode.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ProjectName: mybatis-course
 * @Package: com.powernode.utils
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/7 16:10
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */

public class MyBatis_Utils {
    //
    private static SqlSessionFactory factory = null;

    static {
        //1.定义MyBatis主配置文件的名称，
        // 从类路径的根开始【target/classes】

        String config = "mybatis.xml";
        try {
            //2.读取config所表示的文件
            InputStream inputStream = Resources.getResourceAsStream(config);
            //3.创建SqlSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //4.创建SqlSessionFactory对象
            factory = sqlSessionFactoryBuilder.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取sqlSession的方法
     */
    public static SqlSession get_sqlSession() {
        SqlSession sqlSession = null;
        if (factory != null) {
            //获取自动提交机制的sqlSession对象
            sqlSession = factory.openSession(true);
        }
        return sqlSession;
    }
}
