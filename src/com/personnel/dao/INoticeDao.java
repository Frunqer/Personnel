package com.personnel.dao;

import java.util.List;

import com.personnel.bean.notice.Notice;

/**
 * 对公告信息表进行操作
 * @author zhouzhenjiang
 *
 */
public interface INoticeDao {

    /**
     * 获取公告前几条
     * @return
     * @number 前几条
     */
    public List<Notice> getNoticesTop(int number);
    
    /**
     * 根据ID获取对应的公告
     * @param id
     * @return
     */
    public Notice getNoticeById(int id);
    
    /**
     * 持久化公告信息
     * @param notice
     * @return
     */
    public int save(Notice notice);
    
    /**
     * 用于分页查询数据
     * @param startPage 起始位
     * @param endPage   每页数量
     * @return
     */
    public List<Notice> getNoticesByPage(int startPage,int perPage);
    
    /**
     * 获取数据库中所有Notice的数量
     * @return
     */
    public int getNoticeCount();
    
}
