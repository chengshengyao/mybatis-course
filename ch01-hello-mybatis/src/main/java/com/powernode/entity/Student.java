package com.powernode.entity;

/**
 * @ProjectName: mybatis-course
 * @Package: com.powernode.entity
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/7 9:09
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
//推荐与表名一致容易记忆
public class Student {
    //ToString

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    //定义属性，要求与列名一致
    private Integer id;
    private String name;
    private String email;
    private Integer age;

    //Getter and Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
