package com.personnel.action.mysupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 自定义的Action，用来封装Action共用的对象
 * @author zhouzhenjiang
 *
 */
public class MyActionSupport extends ActionSupport implements
        ServletRequestAware, ServletResponseAware {
    
    protected HttpServletResponse response;
    protected HttpServletRequest request;
    protected Logger logger = Logger.getLogger(MyActionSupport.class);

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String execute() throws Exception {
        return super.execute();
    }
}
