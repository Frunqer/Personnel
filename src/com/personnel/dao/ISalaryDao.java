package com.personnel.dao;

import com.personnel.bean.user.Salary;

/**
 * 操作薪酬表
 * @author zhouzhenjiang
 *
 */
public interface ISalaryDao {
    
    /**
     * 根据email获取对应薪酬对象
     * @param email
     * @return
     */
    public Salary getSalaryByEmail(String email);
    
    /**
     * 持久化薪酬对象
     * @param salary
     * @return
     */
    public int save(Salary salary);
    
    /**
     * 更新对应的薪酬
     * @param salary
     * @return
     */
    public int update(Salary salary);

}
