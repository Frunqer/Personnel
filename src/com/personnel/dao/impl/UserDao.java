package com.personnel.dao.impl;

import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;

import com.personnel.bean.user.UserInfo;
import com.personnel.dao.IUserDao;
import com.personnel.utils.StrUtils;

public class UserDao implements IUserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertImgHead(String path, String email) {

        String sql = "update core_user set head_image = ? where email = ?";
        return jdbcTemplate.update(sql, new Object[] { path, email },
                new int[] { Types.VARCHAR, Types.VARCHAR });
    }

    @Override
    public int updateUser(UserInfo userInfo) {
        String sql = "update core_user set name=?,sex=?,birthday=?,mobile=?,qq=?,native=?,policies=? where email= ?";

        return jdbcTemplate.update(
                sql,
                new Object[] { userInfo.getName(), userInfo.getSex(),
                       StrUtils.formatStrToDate(userInfo.getBirthday()), userInfo.getMobile(),
                        userInfo.getQq(), userInfo.getNative_home(),
                        userInfo.getPolicies(), userInfo.getEmail() },
                new int[] { Types.VARCHAR, Types.CHAR, Types.DATE,
                        Types.VARCHAR, Types.VARBINARY, Types.VARCHAR,
                        Types.VARCHAR, Types.VARCHAR});
    }

}
