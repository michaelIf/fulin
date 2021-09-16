package com.fulin.entity;

public class Fu_users {
    private Integer userId;//用户编号
    private String userName;//用户名称
    private String password;//用户密码
    private String sex;//用户性别
    private String email;//用户邮箱
    private String phone;//用户手机号

    public Fu_users() {
    }

    public Fu_users(Integer userId, String userName, String password, String sex, String email, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
