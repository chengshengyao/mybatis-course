package com.bjpowenode;

import com.bjpowenode.dao.StudentDao;
import com.bjpowenode.entity.Student;
import com.bjpowenode.utils.MyBatis_Utils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
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
    public void testSelectStudentIf() {
        /**
         * 使用MyBatis的动态代理机制，使用sqlSession.getMapper（dao接口）
         * 使用getMapper 获取dao接口对应的实现类对象
         */
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        StudentDao proxy = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
//        student.setName("大飞");
        student.setAge(18);
        List<Student> list = proxy.selectStudentIf(student);
        list.forEach(student1 -> System.out.println(student));
    }

    @Test
    public void testSelectStudentWhere() {
        /**
         * 使用MyBatis的动态代理机制，使用sqlSession.getMapper（dao接口）
         * 使用getMapper 获取dao接口对应的实现类对象
         */
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        StudentDao proxy = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        //    student.setName("大飞");
        student.setAge(18);
        List<Student> list = proxy.selectStudentWhere(student);
        for (Student s :
                list) {
            System.out.println("学生=" + s);
        }
    }

    @Test
    public void tesForListAddSQL() {
        StringBuffer stringBuffer = new StringBuffer();
        String sql = "select * from student in";
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        StringBuffer star = stringBuffer.append(sql).append("(");
        for (Integer i : list) {
            stringBuffer.append(i).append(",");

        }
        StringBuffer in = star.deleteCharAt(star.length() - 1);
        StringBuffer end = in.append(")");
        System.out.println(end);
    }

    @Test
    public void testSelectStudentForEach_1() {
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        StudentDao sqlSessionMapperProxy = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students = sqlSessionMapperProxy.selectStudentForEach_1(list);
        //对于结果的【对象集合】遍历，我个人认为 使用迭代中遍历
        for (Student s :
                students) {
            System.out.println("在此范围内的，学生===" + s);
        }
    }

    @Test
    public void testSelectStudentForEach_2() {
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        StudentDao sqlSessionMapperProxy = sqlSession.getMapper(StudentDao.class);
        List<Student> list = new ArrayList<>();
        Student s1 = new Student();//声明 并 初始化 对象
        s1.setId(1004);
        list.add(s1);
        s1 = new Student();//重新开辟空间进赋值
        s1.setId(1007);
        list.add(s1);

        List<Student> students = sqlSessionMapperProxy.selectStudentForEach_2(list);
        //对于结果的【对象集合】遍历，我个人认为 使用迭代中遍历
        for (Student s :
                students) {
            System.out.println("在此范围内的，学生===" + s);
        }
    }
    @Test
    public void testSelectStudentForEach_3() {
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        StudentDao sqlSessionMapperProxy = sqlSession.getMapper(StudentDao.class);
        List<Student> list = new ArrayList<>();
        Student s1 = new Student();//声明 并 初始化 对象
        s1.setId(1004);
        list.add(s1);
        s1 = new Student();
        s1.setId(1005);
        list.add(s1);

        List<Student> students = sqlSessionMapperProxy.selectStudentForEach_3(list);
        //对于结果的【对象集合】遍历，我个人认为 使用迭代中遍历
        for (Student s :
                students) {
            System.out.println("在此范围内的，学生===" + s);
        }
    }
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        StudentDao sqlSessionMapper_Proxy = sqlSession.getMapper(StudentDao.class);
        //加入PageHelper的分页功能
        PageHelper.startPage(3,2);
        List<Student> students = sqlSessionMapper_Proxy.selectAll();
        for (Student s :
                students) {
            System.out.println("所分页，学生===" + s);
        }
    }
    }

