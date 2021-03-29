package com.bjpowenode.dao;

import com.bjpowenode.entity.Student;

import java.util.List;

/**
 * @ProjectName: mybatis-course
 * @Package: com.bjpowenode.dao
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/7 16:55
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
public interface StudentDao {

    //动态SQL使用JAVA对象作为参数
    List<Student> selectStudentIf(Student student);

    List<Student> selectStudentWhere(Student student);
    //<foreach>标签的第一种用法，处理SQL 条件范围 进行对占位符 进行赋值
    List<Student> selectStudentForEach_1(List<Integer> idlist);
    //<foreach>标签的第二种用法，
    List<Student> selectStudentForEach_2(List<Student> stu_list);

    List<Student> selectStudentForEach_3(List<Student> stu_list);
    //使用PageHelper分页查询
    List<Student> selectAll();

}
