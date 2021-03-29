package com.bjpowernode.style.entity;

import java.io.Serializable;

/**
 * (Dept)实体类
 *
 * @author makejava
 * @since 2021-01-28 18:45:50
 */
public class Dept implements Serializable {
    private static final long serialVersionUID = -36672777375014356L;

    private Integer deptno;

    private String dname;

    private String loc;


    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

}