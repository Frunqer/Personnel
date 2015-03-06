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
}
