package com.bjpowenode.entity;

/**
 * @ProjectName: mybatis-course
 * @Package: com.bjpowenode.entity
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/8 20:18
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
public class MyStudent {
    private Integer stuid;
    private String stuname;
    private String stuemail;
    private Integer stuage;

    @Override
    public String toString() {
        return "MyStudent{" +
                "stuid=" + stuid +
                ", stuname='" + stuname + '\'' +
                ", stuemail='" + stuemail + '\'' +
                ", stuage=" + stuage +
                '}';
    }

    public MyStudent(Integer stuid, String stuname, String stuemail, Integer stuage) {
        this.stuid = stuid;
        this.stuname = stuname;
        this.stuemail = stuemail;
        this.stuage = stuage;
    }
}
