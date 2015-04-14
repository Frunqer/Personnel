package com.personnel.action.menulist;

import javax.servlet.http.HttpSession;

import com.personnel.action.mysupport.MyActionSupport;

/**
 * 用来区分不同菜单的做不导航栏
 * @author zhouzhenjiang
 *
 */
public class MenuListAction extends MyActionSupport {

    
    
    @Override
    public String execute() throws Exception {
        
        response.setCharacterEncoding("UTF-8");
        
        //获取menu参数等级
        String num = request.getParameter("num");
        HttpSession session = request.getSession();
        String result = "";
        
        if(num != null && !"".equals(num)){
            session.setAttribute("menuLevel", num);
            result = "menu_success";
        }else{
            result="error";
        }
        return result;
    }
}
