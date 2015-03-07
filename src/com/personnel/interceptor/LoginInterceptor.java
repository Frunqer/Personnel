package com.personnel.interceptor;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 用于判断用户是否登录的拦截器
 * 
 * @author zhouzhenjiang
 * 
 */
public class LoginInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        // 获取访问链接的url
        String url = ServletActionContext.getRequest().getRequestURI()
                .toString();
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);

        // 对登录和注册，验证码获取等操作不进行判断
        if (url.indexOf("login.action") != -1
                || url.indexOf("reg.action") != -1
                || url.indexOf("code.action") != -1) {
           return    invocation.invoke();

        } else {
            // 验证Session是否过期
            if (!ServletActionContext.getRequest().isRequestedSessionIdValid()) {
                // session过期,转向session过期提示页,最终跳转至登录页面
                return "relogin";
            } else {
                String username = (String) ServletActionContext.getRequest()
                        .getSession().getAttribute("loginUser");
                // 验证是否已经登录
                if (username == null) {
                    // 尚未登录,跳转至登录页面
                    return "relogin";
                } else {
                    return invocation.invoke();

                }
            }
        }

    }

}
