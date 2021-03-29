package com.bjpowenode.dao;

import com.bjpowenode.entity.MyStudent;
import com.bjpowenode.entity.Student;
import com.bjpowenode.vo.QueryParam;
import com.bjpowenode.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    //    传入的一个简单类型的参数
    //mybatis中将java中的基本数据类型 和String定义为简单类型
    //在SQLMapper文件中使用【占位符】#{任意字符}获取简单类型 参数的值

    Student selectStudentByID(Integer id);

    /**
     * 多个命名参数 形式
     *
     * @param name
     * @param age
     * @return
     */
    List<Student> selectMultiParam(@Param("human_name") String name, @Param("human_age") Integer age);

    /**
     * 多个参数，使用java对象作为接口中方法的参数
     */
    List<Student> selectMultiObject(QueryParam queryParam);

    List<Student> selectMultiStudent(Student student);
    //多个对象-简单类型 按位置传值
    //3.4 版本前 使用#{0}...进行参数传值  后 使用#{arg0}...  此处核心思想 # 就他妈是 占位符
    //内部创建 预编译清单对象 进行 预编译 避免 了  sql注入
    List<Student> selectMultiPosition(String name,Integer age);
    /**
     * 使用MAP集合进行传值
     */
    List<Student> selectMultiByMap(Map<String,Object> map);
    /**
     * 使用$符号进行参数传递，演示其安全性低
     * SQL注入
     */
    List<Student> selectUse$(@Param("stuname") String name);

    List<Student> selectUse$Order(@Param("colAge") String age);

    ViewStudent selectStudentReturnViewStudent(@Param("sid") Integer id);

    int countStudent();
    //定义接口返回Map
    Map<Object,Object> selectMapById(Integer id);
    //使用resultmap
    // 定义映射关系
    List<Student> selectAllStudent();

    List<MyStudent> selectMyStudent();

    List<MyStudent> selectDiff_Col_ProPerty_MyStudent();

    List<Student> selectLikeFirst(String name);

    List<Student> selectLikeSecond(String name);
}
