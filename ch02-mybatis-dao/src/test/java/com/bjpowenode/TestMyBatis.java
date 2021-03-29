package com.bjpowenode;

import com.bjpowenode.dao.StudentDao;
import com.bjpowenode.dao.impl.ImplStudentDao;
import com.bjpowenode.entity.Student;
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
        StudentDao dao = new ImplStudentDao();
        List<Student> selectStudents = dao.selectStudents();
        selectStudents.forEach(student -> System.out.println(student));
    }

    //测试添加方法
    @Test
    public void testInsert() {
        ImplStudentDao dao = new ImplStudentDao();
        Student student = new Student();
        student.setId(9999);
        student.setName("test_dao_date1");
        student.setEmail("test@Junit.com");
        student.setAge(1);
        int result = dao.insertStudents(student);
        System.out.println("使用传统的DAO执行INSERT语句影响数据库表" + result + "条记录");
    }

    //测试删除方法
    @Test
    public void testDelete() {
        StudentDao dao = new ImplStudentDao();
        int result = dao.deleteStudent(1001);
        System.out.println("使用传统的DAO执行DELETE语句影响数据库表" + result + "条记录");
    }
    //测试更新方法
    @Test
    public void testUpdate() {
        ImplStudentDao dao = new ImplStudentDao();
        Student student = new Student();
        student.setId(9999);
        student.setName("test_dao_date1");
        student.setEmail("test@Junit.com");
        student.setAge(80);
        int result = dao.updateStudent(student);
        System.out.println("使用传统的DAO执行UPDATE语句影响数据库表" + result + "条记录");
    }

}
