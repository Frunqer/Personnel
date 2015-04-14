package com.personnel.action.login;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import com.personnel.action.mysupport.MyActionSupport;
import com.personnel.bean.user.UserInfo;
import com.personnel.dao.ILoginDao;
import com.personnel.dao.IRegisterDao;



/**
 * 登陆请求类
 * @author zhouzhenjiang
 *
 */
public class LoginAction extends MyActionSupport {
    
    private static final long serialVersionUID = 1L;
    
    private ILoginDao loginDao;
    
    private IRegisterDao registerDao;

    public void setLoginDao(ILoginDao loginDao) {
        this.loginDao = loginDao;
    }

    public void setRegisterDao(IRegisterDao registerDao) {
        this.registerDao = registerDao;
    }

    @Override
    public String execute() throws Exception {
        
        
        response.setCharacterEncoding("UTF-8");
        String uEmail = request.getParameter("email");
        
        String uPwd = request.getParameter("pwd");
        
        //实现多浏览器共用一个session对象
        HttpSession session = request.getSession();
       
        boolean isExist = loginDao.isExist(uEmail)>0?true:false;
        
        String message= "";
        if(isExist){
            //说明存在
            int isOK = loginDao.confirmUser(uEmail, uPwd);
            
            if(isOK > 0){
                UserInfo userInfo  = registerDao.getUserByEmail(uEmail);
                //说明密码正确
                message ="success";
                //登录成功，后将用户加入到session中，并设置session的时间限制
                //将登录的用户对象存放到session中
                session.setAttribute("loginUser", userInfo);
                Cookie cookie = new Cookie("JSESSIONID",session.getId());//把系统的session id的覆盖掉  
                cookie.setMaxAge(5*360);  
                cookie.setPath("/Personnel");  
                response.addCookie(cookie);
                
            }else{
                //说明密码错误
                message = "error" ;
            }
        }else{
            //说明不存在改用户
            message="noexist";
        }
        response.getWriter().write(message);
        return null;
    }

}
