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
     List<Student> selectStudents();
     int insertStudents(Student student);
}
