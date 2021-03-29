package com.powernode.dao;

import com.powernode.entity.Student;

import java.util.List;

/**
 * @ProjectName: mybatis-course
 * @Package: com.powernode.dao
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/7 9:14
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
// @-2 dao持久层 中定义接口 StudentDao
//    描述以操作数据库的方法
public interface StudentDao {
    /**
     * 第一个功能方法 查询 表中所有数据
     * @return 返回一个LIST<Student>集合
     */
   public List<Student> selectStudents();

    /**
     * 第二个功能方法  插入
     * @param student
     * @return 返回值是 整型【执行insert语句后在数据库的表中影响行数】 result
     */
   public int insertStudent(Student student);

}
