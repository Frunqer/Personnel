package com.personnel.bean.code;

/**
 * 验证码信息表
 * @author zhouzhenjiang
 *
 */
public class Code {

    private int id;
    private int code;
    private String code_date;
    private String email;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getCode_date() {
        return code_date;
    }
    public void setCode_date(String code_date) {
        this.code_date = code_date;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
