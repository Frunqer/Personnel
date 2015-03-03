package com.personnel.bean.role;

/**
 * 角色信息
 * @author zhouzhenjiang
 *
 */
public class Role {
    private int role_id;
    private String role_info;
    public Role() {
        super();
    }
    public int getRole_id() {
        return role_id;
    }
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
    public String getRole_info() {
        return role_info;
    }
    public void setRole_info(String role_info) {
        this.role_info = role_info;
    }
    
}
