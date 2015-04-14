package com.personnel.action.page;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;

import com.personnel.action.mysupport.MyActionSupport;
import com.personnel.bean.notice.Notice;
import com.personnel.dao.INoticeDao;

/**
 * 进行分页操作
 * @author zhouzhenjiang
 *
 */
public class PageAction extends MyActionSupport {
    
    public static final int NOTICE_PAGE_PER=10;
    
    private INoticeDao noticeDao ;

    public void setNoticeDao(INoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }
    
    @Override
    public String execute() throws Exception {
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        
        if(action != null && !"".equals(action)){
            if(action.equals("notice")){
                //进行notice的分页操作
                pageForNotice();
            }
        }
        return null;
    }
    /**
     * 为notice进行分页操作处理
     * @throws Exception 
     */
    private void pageForNotice() throws Exception {
        //由js组件自动封装的参数
        String pageString = request.getParameter("page");
        
        int sum=noticeDao.getNoticeCount();
        
        //每页显示的条数为10条，计算需要的页数
        int pageCount=0;
        
        if(sum%10 == 0){
            pageCount = sum/10;
        }else{
            pageCount =sum/10 +1;
        }
        int page = Integer.parseInt(pageString);
        //每页显示10条数据
        int initialNum = page*NOTICE_PAGE_PER;//初始化页数
        int startPage = initialNum-NOTICE_PAGE_PER;
        List<Notice> notices = noticeDao.getNoticesByPage(startPage, NOTICE_PAGE_PER);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("notices", notices);
        //分页操作的时候一定要加上这两个参数，不然前段渲染的时候回出错
        jsonObject.put("recordCount", sum);
        jsonObject.put("pageCount", pageCount);
        System.out.println(jsonObject.toString());
        response.getWriter().write(jsonObject.toString());
        
    }

}
