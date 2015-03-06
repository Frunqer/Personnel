package com.personnel.dao.impl;

import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.personnel.bean.user.UserInfo;
import com.personnel.dao.IRegisterDao;

public class RegisterDaoImpl implements IRegisterDao {
    
    private Logger logger = Logger.getLogger(RegisterDaoImpl.class);
    
    private JdbcTemplate jdbcTemplate;
    
    //有spring自动配置给当前对象
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(UserInfo userInfo) {
        logger.info("[RegisterDaoImpl]保存操作");
        String sql="insert into core_user(email,password) values(?,?)";
      return  jdbcTemplate.update(sql, new Object[]{userInfo.getEmail(),userInfo.getPassword()}, new int[]{Types.VARCHAR,Types.VARCHAR});
    }

    @Override
    public void delete(Integer uid) {
        logger.info("[RegisterDaoImpl]删除操作");
    }

    @Override
    public List<UserInfo> findAllUserInfos() {
        logger.info("[RegisterDaoImpl]查询所有的用户信息");
        return null;
    }

}
