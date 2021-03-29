package com.bjpowenode;

import com.bjpowenode.dao.StudentDao;
import com.bjpowenode.entity.Student;
import com.bjpowenode.utils.MyBatis_Utils;
import com.bjpowenode.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void testSelectStudentByID() {
        /**
         * 使用MyBatis的动态代理机制，使用sqlSession.getMapper（dao接口）
         * 使用getMapper 获取dao接口对应的实现类对象
         */
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        StudentDao sqlSessionMapper_proxy = sqlSession.getMapper(StudentDao.class);
        Student student = sqlSessionMapper_proxy.selectStudentByID(1003);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testSelectMultiParam(){
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        StudentDao sqlSessionMapper_proxy = sqlSession.getMapper(StudentDao.class);
        List<Student> list = sqlSessionMapper_proxy.selectMultiParam("大飞", 23);
        list.forEach(student -> System.out.println(student));
        sqlSession.close();
    }
    @Test
    public void testSelectMultiObject(){
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        StudentDao sqlSessionMapper_proxy = sqlSession.getMapper(StudentDao.class);
        QueryParam queryParam = new QueryParam();
        queryParam.setParamName("大飞");
         List<Student> list = sqlSessionMapper_proxy.selectMultiObject(queryParam);
        list.forEach(student -> System.out.println(student));
        sqlSession.close();
    }
    @Test
    public void testSelectMultiStudent(){
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        StudentDao sqlSessionMapper_proxy = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("大飞");
        student.setAge(28);
        List<Student> list = sqlSessionMapper_proxy.selectMultiStudent(student);
        list.forEach(s -> System.out.println(s));
        sqlSession.close();
    }
    @Test
    public void testSelectMultiPosition(){
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        StudentDao sqlSessionMapper_proxy = sqlSession.getMapper(StudentDao.class);
        List<Student> list = sqlSessionMapper_proxy.selectMultiPosition("动态代理牛逼",66);
        list.forEach(s -> System.out.println(s));
        sqlSession.close();
    }
    @Test
    public void testSelectMultiByMap(){
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        StudentDao sqlSessionMapper_proxy = sqlSession.getMapper(StudentDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("sbname","大飞");
        map.put("sbage",44);
        List<Student> list = sqlSessionMapper_proxy.selectMultiByMap(map);
        list.forEach(s -> System.out.println(s));
        sqlSession.close();
    }
    @Test
    public void testSelectUse$() {
        /**
         * 使用MyBatis的动态代理机制，使用sqlSession.getMapper（dao接口）
         * 使用getMapper 获取dao接口对应的实现类对象
         */
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        StudentDao sqlSessionMapper_proxy = sqlSession.getMapper(StudentDao.class);
        //$ 传递参数是真的拉胯，安全隐患很大
        List<Student> list = sqlSessionMapper_proxy.selectUse$("\"大飞\"");
        list.forEach(student -> System.out.println(student));
        sqlSession.close();
    }
    @Test
    public void testSelectUse$Order() {
        /**
         * 使用MyBatis的动态代理机制，使用sqlSession.getMapper（dao接口）
         * 使用getMapper 获取dao接口对应的实现类对象
         */
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        StudentDao sqlSessionMapper_proxy = sqlSession.getMapper(StudentDao.class);
        List<Student> list = sqlSessionMapper_proxy.selectUse$Order("age");
        list.forEach(student -> System.out.println(student));
        sqlSession.close();
    }

//    @Test
//    public void testInsert() {
//        /**
//         * 使用MyBatis的动态代理机制，使用sqlSession.getMapper（dao接口）
//         * 从而获取 dao接口的实现类对象【这他妈就是动态代理】
//         */
//        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
//        StudentDao sqlSessionMapper = sqlSession.getMapper(StudentDao.class);
//        Student student = new Student();
//        student.setId(666);
//        student.setName("动态代理牛逼");
//        student.setEmail("dynamicproxy@niubillty.com");
//        student.setAge(6);
//        int result = sqlSessionMapper.insertStudents(student);
//        System.out.println("使用传统的DAO执行INSERT语句影响数据库表" + result + "条记录");
//    }

}
