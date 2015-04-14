package com.personnel.bean.user;

import java.sql.Timestamp;

/**
 * 考勤表
 * @author zhouzhenjiang
 *
 */
public class Checkin {

    private int check_id;
    private String email;
    private Timestamp check_morning;//早上打卡时间
    private Timestamp check_night;//下午打卡时间
    private String morning_status;//迟到状态
    private String night_status;//早退状态
    private String status;//考勤状态
    private int flag;
    private Timestamp create_time;
    private int weekday;
  
    public int getWeekday() {
        return weekday;
    }
    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }
    public int getCheck_id() {
        return check_id;
    }
    public void setCheck_id(int check_id) {
        this.check_id = check_id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Timestamp getCheck_morning() {
        return check_morning;
    }
    public void setCheck_morning(Timestamp check_morning) {
        this.check_morning = check_morning;
    }
    public Timestamp getCheck_night() {
        return check_night;
    }
    public void setCheck_night(Timestamp check_night) {
        this.check_night = check_night;
    }
    public String getMorning_status() {
        return morning_status;
    }
    public void setMorning_status(String morning_status) {
        this.morning_status = morning_status;
    }
    public String getNight_status() {
        return night_status;
    }
    public void setNight_status(String night_status) {
        this.night_status = night_status;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getFlag() {
        return flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }
    public Timestamp getCreate_time() {
        return create_time;
    }
    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }
    public Checkin() {
        super();
        // TODO Auto-generated constructor stub
    }
    

    
}
