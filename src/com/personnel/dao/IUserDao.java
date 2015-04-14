package com.personnel.dao;

import com.personnel.bean.user.UserInfo;

/**
 * 操作User类
 * @author zhouzhenjiang
 *
 */
public interface IUserDao {

    /**
     * 插入头像
     * @param path
     * @param email
     * @return
     */
    public int insertImgHead(String path,String email);
    
    /**
     * 更新UserInfo
     * @param userInfo
     * @return
     */
    public int updateUser(UserInfo userInfo);
}
