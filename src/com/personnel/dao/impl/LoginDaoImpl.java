package com.personnel.dao.impl;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;

import com.personnel.dao.ILoginDao;

public class LoginDaoImpl implements ILoginDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int confirmUser(String email, String password) {
        String sql = "select count(*) from core_user where email=? and password=?";
       return jdbcTemplate.queryForInt(sql, new Object[] { email, password },
                new int[] { Types.VARCHAR, Types.VARCHAR });

        
    }

}
