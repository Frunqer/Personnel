package com.personnel.bean.user;


/**
 *用户工作信息表
 * @author zhouzhenjiang
 *
 */
public class UserWorkInfo {
    private int uid;//与userinfo的id相关联
    private int department_id;
    private String post;//岗位
    private String entry_date;//入职日期
    private String salary_num;//工资号
    private String identity_num;//身份证号
    private int status;//职员状态
    
    public UserWorkInfo() {
        super();
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public int getDepartment_id() {
        return department_id;
    }
    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public String getEntry_date() {
        return entry_date;
    }
    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }
    public String getSalary_num() {
        return salary_num;
    }
    public void setSalary_num(String salary_num) {
        this.salary_num = salary_num;
    }
    public String getIdentity_num() {
        return identity_num;
    }
    public void setIdentity_num(String identity_num) {
        this.identity_num = identity_num;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    

}
