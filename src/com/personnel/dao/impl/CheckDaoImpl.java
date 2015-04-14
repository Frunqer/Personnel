package com.personnel.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.personnel.bean.user.Checkin;
import com.personnel.dao.ICheckinDao;
import com.sun.faces.mgbean.ManagedBeanPreProcessingException.Type;

public class CheckDaoImpl implements ICheckinDao {
    private Logger logger = Logger.getLogger(CheckDaoImpl.class);

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Checkin checkin, String month) {
        logger.info("早上打卡记录");
        String sql = "insert into core_checkin"
                + month
                + "(email,check_morning,check_night,morning_status,night_status,status,flag,create_time,weekday) "
                + " values(?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(
                sql,
                new Object[] { checkin.getEmail(), checkin.getCheck_morning(),
                        checkin.getCheck_night(), checkin.getMorning_status(),
                        checkin.getNight_status(), checkin.getStatus(),
                        checkin.getFlag(), checkin.getCreate_time(),
                        checkin.getWeekday() }, new int[] { Types.VARCHAR,
                        Types.TIMESTAMP, Types.TIMESTAMP, Types.VARCHAR,
                        Types.VARCHAR, Types.VARCHAR, Types.INTEGER,
                        Types.TIMESTAMP, Types.INTEGER });
    }

    @Override
    public int updateCheckin(Checkin checkin, String month) {
        logger.info("更新打卡记录");
        String sql = "update core_checkin"
                + month
                + " set check_night=?,night_status=? where email=? and weekday=?";
        return jdbcTemplate.update(
                sql,
                new Object[] { checkin.getCheck_night(),checkin.getNight_status(),
                        checkin.getEmail(),
                        checkin.getWeekday() }, new int[] { Types.TIMESTAMP,Types.VARCHAR,
                        Types.VARCHAR, Types.INTEGER });
    }

    @Override
    public List<Checkin> getAllByUser(String email, String month) {
        logger.info("获取当前月份的考情月份");
        String sql = "select * from core_checkin" + month + " where email=?";
        return jdbcTemplate.query(sql, new Object[] { email },
                new int[] { Types.VARCHAR }, new CheckinRowMapper());
    }

    @Override
    public Checkin getCheckinByEmail(String email, String month, int weekday) {
        logger.info("查看对应的考勤记录");
        String sql = "select * from core_checkin" + month
                + " where email=? and weekday=?";
        return jdbcTemplate.queryForObject(sql,
                new Object[] { email, weekday }, new int[] { Types.VARCHAR,
                        Types.INTEGER }, new CheckinRowMapper());
    }
   
    
    
    
    class CheckinRowMapper implements RowMapper<Checkin> {

        @Override
        public Checkin mapRow(ResultSet rs, int index) throws SQLException {
            Checkin checkin = new Checkin();
            checkin.setEmail(rs.getString("email"));
            checkin.setCheck_morning(rs.getTimestamp("check_morning"));
            checkin.setCheck_night(rs.getTimestamp("check_night"));
            checkin.setMorning_status(rs.getString("morning_status"));
            checkin.setNight_status(rs.getString("night_status"));
            checkin.setStatus(rs.getString("status"));
            checkin.setCreate_time(rs.getTimestamp("create_time"));
            checkin.setFlag(rs.getInt("flag"));
            checkin.setWeekday(rs.getInt("weekday"));
            return checkin;
        }

    }




    @Override
    public int isExistForEmail(String email, String month, int weekday) {
        
        String sql = "select count(*) from core_checkin"+month+" where email=? and weekday=?";
        
        return jdbcTemplate.queryForInt(sql, new Object[]{email,weekday}, new int[]{Types.VARCHAR,Types.INTEGER});
    }

   

}
