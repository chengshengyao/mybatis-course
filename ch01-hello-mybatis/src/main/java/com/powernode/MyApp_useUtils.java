package com.powernode;

import com.powernode.entity.Student;
import com.powernode.utils.MyBatis_Utils;
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
public class MyApp_useUtils {
    public static void main(String[] args) throws IOException {
        //   @-5 .创建使用MtBatis类访问数据库
        //使用工具类封装【1-5】了创建sqlSession对象的方法
        // 【静态方法，通过”类名点“调用】
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        //6.指定执行SQL语句的标识[sql mapper 文件中的namespace]+[.]+[sql mapper 文件中的标签ID值]
        String sqlId="com.bjpowernode.dao.StudentDao.selectStudents";
        //7.通过【6. sqlID】寻找执行SQL语句
        List<Student> list = sqlSession.selectList(sqlId);
        //8.输出结果
        list.forEach(s-> System.out.println(s));
        //9.关闭
        sqlSession.close();

    }
}
