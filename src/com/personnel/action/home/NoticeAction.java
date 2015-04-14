package com.personnel.action.home;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import sun.print.resources.serviceui;

import com.personnel.action.mysupport.MyActionSupport;
import com.personnel.bean.notice.Notice;
import com.personnel.dao.INoticeDao;

/**
 * 用于响应notice有关的操作
 * 
 * @author zhouzhenjiang
 * 
 */
public class NoticeAction extends MyActionSupport {

    private INoticeDao noticeDao;

    public void setNoticeDao(INoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }

    @Override
    public String execute() throws Exception {

        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        String result ="";

        if (action != null || !"".equals(action)) {
            if ("top".equals(action)) {
                //获取前几天公告
              result =  getNoticeTop();
            }else if("single".equals(action)){
                //根据ID获取公告
              result =  getNoticeById();
            }else if("more".equals(action)){
                result = getNoticeCount();
            }
        }

        return result;
    }

    /**
     *  获取数据库中的总的数据量
     * @return
     */
    private String getNoticeCount() {
        return "go_list";
    }

    /*
     * 根据ID获取公告
     */
    private String getNoticeById() {
        
        String id = request.getParameter("id");
        
        if(id!=null && !id.equals("")){
            
            Notice notice = noticeDao.getNoticeById(Integer.parseInt(id));
            
            request.setAttribute("singleNotice", notice);
            return "get_success";
        }else{
            return "error";
        }
        
       
    }

    /**
     * 获取前6条公告信息
     * @throws Exception 
     */
    private String getNoticeTop() throws Exception {

        
        List<Notice> notices = noticeDao.getNoticesTop(6);
        HttpSession session = request.getSession();
        session.setAttribute("notices", notices);
        session.setAttribute("menuLevel", "1");
        
        return "notice_success";
        
     
    }

}
