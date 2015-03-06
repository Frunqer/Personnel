package com.personnel.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.personnel.bean.code.Code;
import com.personnel.dao.ICodeDao;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.org.apache.regexp.internal.recompile;

public class CodeDaoImpl implements ICodeDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Code getCode(String email) {

        // 获取对应邮箱的最新一条数据
        String sql = "select  code,email,code_date from core_code where email= ? "
                + "order by id desc limit 0,1";
        
        Code code = (Code) jdbcTemplate.queryForObject(sql, new Object[] { email },new CodeRowMapper());
        return code;
    }

    @Override
    public void save(Code code) {
        String sql = "insert into core_code(code,code_date,email) values(?,?,?)";

        jdbcTemplate.update(
                sql,
                new Object[] { code.getCode(), code.getCode_date(),
                        code.getEmail() }, new int[] { Types.VARCHAR,
                        Types.TIMESTAMP, Types.VARCHAR });

    }

    class CodeRowMapper implements RowMapper<Code> {

        @Override
        public Code mapRow(ResultSet rs, int index) throws SQLException {
            Code code = new Code();
            code.setCode(rs.getString("code"));
            code.setEmail(rs.getString("email"));
            code.setCode_date(rs.getTimestamp("code_date"));
            return code;
        }
    }

}
