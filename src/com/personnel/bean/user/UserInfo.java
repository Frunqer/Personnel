package com.personnel.bean.user;

/**
 * 用户的基本信息bean
 * @author zhouzhenjiang
 *
 */
public class UserInfo {
    private int id;//标识
    private String name;//用户名称
    private String password;//密码
    private char sex;//性别
    private String birthday;//出生日期
    private String mobile;//手机号
    private String email;//邮箱号
    private String qq;//qq号
    private String native_home;//籍贯
    private String policies;//政治面貌
    private String head_image;//头像地址
    private String role_id;//角色等级
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public char getSex() {
        return sex;
    }
    public void setSex(char sex) {
        this.sex = sex;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getQq() {
        return qq;
    }
    public void setQq(String qq) {
        this.qq = qq;
    }
    public String getNative_home() {
        return native_home;
    }
    public void setNative_home(String native_home) {
        this.native_home = native_home;
    }
    public String getPolicies() {
        return policies;
    }
    public void setPolicies(String policies) {
        this.policies = policies;
    }
    public String getHead_image() {
        return head_image;
    }
    public void setHead_image(String head_image) {
        this.head_image = head_image;
    }
    public String getRole_id() {
        return role_id;
    }
    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }
    public UserInfo() {
        super();
    }
    

}
