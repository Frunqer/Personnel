package com.personnel.dao;

import java.util.List;

import com.personnel.bean.user.Checkin;

/**
 * 操作考勤表
 * @author zhouzhenjiang
 *
 */
public interface ICheckinDao {

    /**
     * 持久化考勤记录
     * @param checkin
     * @return
     */
    public int save(Checkin checkin,String month);
    
    /**
     * 更新考勤状态
     * @param checkin
     * @return
     */
    public int updateCheckin(Checkin checkin,String month);
    
    /**
     * 获取某个员工的月考勤记录汇总
     * @param email
     * @return
     */
    public List<Checkin> getAllByUser(String email,String month);
    
    /**
     * 
     * @param email
     * @param month
     * @param weekday
     * @return
     */
    public Checkin getCheckinByEmail(String email,String month,int weekday);
    
    /**
     * 判断是否有打卡记录
     * @param email
     * @param month
     * @param weekday
     * @return
     */
    public int isExistForEmail(String email,String month,int weekday);
}
