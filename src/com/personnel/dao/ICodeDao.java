package com.personnel.dao;

import com.personnel.bean.code.Code;

public interface ICodeDao {

    /**
     * 根据邮箱获取最新一条的Code
     * @param email
     * @return
     */
    public  Code getCode(String email);
    
    /**
     * 将产生的验证验证码存入数据库当中
     * @param code
     */
    public void save(Code code);
}
