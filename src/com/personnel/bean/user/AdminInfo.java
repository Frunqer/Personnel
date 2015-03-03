package com.personnel.bean.user;

/**
 * 超级管理员
 * @author zhouzhenjiang
 *
 */
public class AdminInfo {

    private int id;
    private String aname;
    private String apwd;
    private int role_id;
    
    public AdminInfo() {
        super();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAname() {
        return aname;
    }
    public void setAname(String aname) {
        this.aname = aname;
    }
    public String getApwd() {
        return apwd;
    }
    public void setApwd(String apwd) {
        this.apwd = apwd;
    }
    public int getRole_id() {
        return role_id;
    }
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
    
}
