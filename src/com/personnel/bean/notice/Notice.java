package com.personnel.bean.notice;

import java.sql.Timestamp;

/**
 * 企业信息公告类
 * @author zhouzhenjiang
 *
 */
public class Notice {
    
    private int id;
  
    private String title;
    private String content;
    private Timestamp createTime;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Timestamp getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
    public Notice() {
        super();
    }
    

}
