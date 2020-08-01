package com.liuweiwei.bean;

import javax.validation.constraints.Pattern;

public class Employee {
    private Integer empId;
    @Pattern(regexp = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})", message = "加个用户名验证注解@Pattern.")
    private String empName;
    private String gender;
    @Pattern(regexp = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$", message = "加个邮箱验证注解@Pattern.")
    private String email;
    private Integer dId;
    private Department department;
}