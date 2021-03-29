package com.bjpowenode.dao.impl;

import com.bjpowenode.dao.StudentDao;
import com.bjpowenode.entity.Student;
import com.bjpowenode.utils.MyBatis_Utils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @ProjectName: mybatis-course
 * @Package: com.bjpowenode.dao.impl
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/7 17:25
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
public class ImplStudentDao implements StudentDao {

    @Override
    public List<Student> selectStudents() {
        //获取SqlSession对象
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        String sqlId = "com.bjpowenode.dao.StudentDao.selectStudents";
        List<Student> list = sqlSession.selectList(sqlId);
        sqlSession.close();
        return list;
    }

    @Override
    public int insertStudents(Student student) {
        //获取SqlSession对象
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        String sqlId = "com.bjpowenode.dao.StudentDao.insertStudents";
        int result = sqlSession.insert(sqlId,student);
        sqlSession.close();
        return result;
    }

    @Override
    public int deleteStudent(int id) {
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        String sqlId="com.bjpowenode.dao.StudentDao.deleteStudent";
        int result = sqlSession.delete(sqlId);
        sqlSession.close();
        return result;
    }

    @Override
    public int updateStudent(Student student) {
        SqlSession sqlSession = MyBatis_Utils.get_sqlSession();
        String sqlId="com.bjpowenode.dao.StudentDao.updateStudent";
        int result = sqlSession.update(sqlId, student);
        sqlSession.close();
        return result;
    }
}
