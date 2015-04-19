package com.personnel.dao;


import java.util.List;

import com.personnel.bean.user.UserInfo;

/**
 * 进行注册操作数据类
 * @author zhouzhenjiang
 *
 */
public interface IRegisterDao {

    /**
     * 保存用户
     * @param userInfo
     */
    public int save(UserInfo userInfo);
    
    /**
     * 删除用户
     * @param uid
     */
    public void delete(Integer uid);
    
    /**
     * 找到所有用户
     * @return
     */
    public List<UserInfo> findAllUserInfos();
    
    /**
     * 根据email获取对应的UserInfo对象
     * @param email
     * @return
     */
    public UserInfo getUserByEmail(String email);
    
    /**
     * 判断是否存在于数据库中
     * @param email
     * @return
     */
    public int isExist(String email);
}
