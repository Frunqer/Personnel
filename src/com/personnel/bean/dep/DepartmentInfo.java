package com.personnel.bean.dep;

/**
 * 部门信息表
 * @author zhouzhenjiang
 *
 */
public class DepartmentInfo {
    private int dep_id;
    private String dep_name;
    private String dep_desc;
    public DepartmentInfo() {
        super();
    }
    public int getDep_id() {
        return dep_id;
    }
    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }
    public String getDep_name() {
        return dep_name;
    }
    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }
    public String getDep_desc() {
        return dep_desc;
    }
    public void setDep_desc(String dep_desc) {
        this.dep_desc = dep_desc;
    }
    

}
