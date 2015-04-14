package com.personnel.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.personnel.bean.user.UserInfo;
import com.personnel.dao.IRegisterDao;
import com.personnel.utils.StrUtils;
import com.sun.org.apache.regexp.internal.recompile;

public class RegisterDaoImpl implements IRegisterDao {

    private Logger logger = Logger.getLogger(RegisterDaoImpl.class);

    private JdbcTemplate jdbcTemplate;

    // 有spring自动配置给当前对象
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(UserInfo userInfo) {
        logger.info("[RegisterDaoImpl]保存操作");
        String sql = "insert into core_user(email,password) values(?,?)";
        return jdbcTemplate.update(sql, new Object[] { userInfo.getEmail(),
                userInfo.getPassword() }, new int[] { Types.VARCHAR,
                Types.VARCHAR });
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

    @Override
    public UserInfo getUserByEmail(String email) {

        String sql = "select * from core_user where email = ? ";

        return jdbcTemplate.queryForObject(sql, new Object[] { email },
                new int[] { Types.VARCHAR }, new UserRowMapper());

    }

    class UserRowMapper implements RowMapper<UserInfo> {

        @Override
        public UserInfo mapRow(ResultSet rs, int index) throws SQLException {
            if (rs != null) {
                UserInfo userInfo = new UserInfo();
                userInfo.setEmail(rs.getString("email"));
                userInfo.setId(rs.getInt("id"));
                userInfo.setPassword(rs.getString("password"));
                userInfo.setHead_image(rs.getString("head_image"));
                userInfo.setName(rs.getString("name"));
                if (rs.getDate("birthday") != null) {
                    userInfo.setBirthday(StrUtils.formatDateToString(rs
                            .getDate("birthday")));
                }
                userInfo.setSex(rs.getString("sex").toCharArray()[0]);
                userInfo.setNative_home(rs.getString("native"));
                userInfo.setMobile(rs.getString("mobile"));
                userInfo.setQq(rs.getString("qq"));
                userInfo.setPolicies(rs.getString("policies"));

                return userInfo;
            } else {
                return null;
            }
        }

    }

}
