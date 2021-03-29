package com.bjpowenode.vo;

/**
 * @ProjectName: mybatis-course
 * @Package: com.bjpowenode.vo
 * @Description: java类作用描述
 * @Author: 生尧
 * @CreateDate: 2021/1/8 8:46
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
public class QueryParam {
    private String paramName;
    private  Integer paramAge;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Integer getParamAge() {
        return paramAge;
    }

    public void setParamAge(Integer paramAge) {
        this.paramAge = paramAge;
    }
}
