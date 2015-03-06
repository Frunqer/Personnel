package com.personnel.bean.code;

import java.sql.Timestamp;

/**
 * 验证码信息表
 * @author zhouzhenjiang
 *
 */
public class Code {

    private int id;
    private String  code;
    private Timestamp code_date;
    private String email;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Timestamp getCode_date() {
        return code_date;
    }
    public void setCode_date(Timestamp code_date) {
        this.code_date = code_date;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
