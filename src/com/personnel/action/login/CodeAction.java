package com.personnel.action.login;

import java.sql.Timestamp;
import java.util.Random;

import com.personnel.action.mysupport.MyActionSupport;
import com.personnel.bean.code.Code;
import com.personnel.dao.ICodeDao;

/**
 * 用来获取验证码
 * @author zhouzhenjiang
 *
 */
public class CodeAction extends MyActionSupport {
    
    private  ICodeDao codeDao;
    

    public void setCodeDao(ICodeDao codeDao) {
        this.codeDao = codeDao;
    }


    @Override
    public String execute() throws Exception {
        response.setCharacterEncoding("UTF-8");
        
        String sysCode = createSysCode();
        
        String email = request.getParameter("email");
        
        Code code =new Code();
        code.setCode(sysCode);
        code.setCode_date(new Timestamp(System.currentTimeMillis()));
        code.setEmail(email);
        //将产生的code插入进数据库中
        codeDao.save(code);
        logger.debug("验证码:"+sysCode);
        //返回给前台产生的六位随机数
        response.getWriter().write(sysCode);
        return null;
    }


    
    /**
     * 系统创建六位的随机验证码
     * @return
     */
    private String createSysCode() {
        Random random = new Random();
        String rRand = "";
        for(int i=0;i<6;i++){
            String rand = String.valueOf(random.nextInt(10));
            rRand+=rand;
        }
        return rRand;
    }
}
