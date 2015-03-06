package com.personnel.action.login;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.personnel.action.mysupport.MyActionSupport;
import com.personnel.bean.code.Code;
import com.personnel.bean.user.UserInfo;
import com.personnel.dao.ICodeDao;
import com.personnel.dao.IRegisterDao;

/**
 * 注册请求类
 * 
 * @author zhouzhenjiang
 * 
 */
public class RegisterAction extends MyActionSupport {

    private IRegisterDao registerDao;
    private ICodeDao codeDao;

    public void setCodeDao(ICodeDao codeDao) {
        this.codeDao = codeDao;
    }

    public void setRegisterDao(IRegisterDao registerDao) {
        this.registerDao = registerDao;
    }

    @Override
    public String execute() throws Exception {
        logger.info("[INFO]进行了注册操作");
        response.setCharacterEncoding("UTF-8");
        // 获取前台传递过来的数据
        String email = request.getParameter("email");

        String pwd = request.getParameter("pwd");

        String code = request.getParameter("code");
        
        String message="";
        // 从数据库中获取email对应的验证码
        Code sysCode = codeDao.getCode(email);
        if (code.equals(sysCode.getCode())) {
            UserInfo userInfo = new UserInfo();
            userInfo.setEmail(email);
            userInfo.setPassword(pwd);
            // 将数据插入到数据库中
            int result = registerDao.save(userInfo);
            
            if(result>0){
                message="success";
            }else{
                message="error";
            }
        }else{
            message="验证码错误";
        }
        response.getWriter().write(message);
        return null;
    }

}