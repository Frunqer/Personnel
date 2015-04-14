package com.personnel.action.home;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import com.personnel.action.mysupport.MyActionSupport;
import com.personnel.bean.user.UserInfo;
import com.personnel.dao.IRegisterDao;
import com.personnel.dao.IUserDao;
import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * 对用户信息进行修改
 * @author zhouzhenjiang
 *
 */
public class UserInfoAction extends MyActionSupport {

    private IUserDao userDao ;
    
    private IRegisterDao registerDao;

    public void setRegisterDao(IRegisterDao registerDao) {
        this.registerDao = registerDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
    
    @Override
    public String execute() throws Exception {
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String result = "";
        
        if(action !=null && !"".equals("action")){
            
            if(action.equals("image")){
                //修改头像
                result = changeHeadImage();
            }else if(action.equals("basic")){
                result = updateUser();
               
            }else if(action.equals("logout")){
                result = logOut();
            }
        }else{
            result = "error";
        }
        return result;
    }

    /**
     * 退出用户
     * @return
     */
    private String logOut() {
        
        //清除Session中的loginUser
        HttpSession session = request.getSession();
        
        session.removeAttribute("loginUser");
        return "logout";
    }

    /**
     * 更新用户信息
     * @return
     * @throws Exception 
     */
    private String updateUser() throws Exception {
        
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        UserInfo loginInfo = (UserInfo) session.getAttribute("loginUser");
        String username = request.getParameter("username");
        char sex = request.getParameter("sex").equals("male")?'男':'女';
        String birthday = request.getParameter("birthday");
        String native_Home =request.getParameter("native");
        String mobile =request.getParameter("mobile");
        String policies = request.getParameter("policies");
        String qq =request.getParameter("qq");
        
        loginInfo.setName(username);
        loginInfo.setBirthday(birthday);
        loginInfo.setNative_home(native_Home);
        loginInfo.setPolicies(policies);
        loginInfo.setSex(sex);
        loginInfo.setMobile(mobile);
        loginInfo.setQq(qq);
        
        int i = userDao.updateUser(loginInfo);
    
        if(i > 0){
            session.setAttribute("loginUser", loginInfo);//更新session中的user
            response.getWriter().write("success");
        }else{
            response.getWriter().write("error");
        }
        
        return null;
    }

    private String changeHeadImage() {
        String email = request.getParameter("email");
        String imagePath = request.getParameter("path");
        HttpSession session = request.getSession();
        if(email!=null &&imagePath!=null){
           int i= userDao.insertImgHead(imagePath, email);
           
           
           if(i>0){
             //重新设置session中的对象
               UserInfo userInfo = registerDao.getUserByEmail(email);
               session.setAttribute("loginUser", userInfo);
               return "img_success";
           }else{
               return "error";
           }
        }else{
            return "error";
        }
      
    }
}
