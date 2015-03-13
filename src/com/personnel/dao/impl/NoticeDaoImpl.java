package com.personnel.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.personnel.bean.notice.Notice;
import com.personnel.dao.INoticeDao;

public class NoticeDaoImpl implements INoticeDao {
    
    private JdbcTemplate jdbcTemplate;
    

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Notice> getNoticesTop(int number) {
        String sql = "select * from core_notice order by notice_time desc limit 0,"+number;
        return jdbcTemplate.query(sql, new NoticeRowMapper());
    }

    @Override
    public Notice getNoticeById(int id) {
        String sql = "select * from core_notice where nid = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new int[]{Types.INTEGER},new NoticeRowMapper());
    }

    @Override
    public int save(Notice notice) {
        
        return 0;
    }
    
    @Override
    public List<Notice> getNoticesByPage(int startPage, int perPage) {
        String sql = "select * from core_notice order by notice_time desc limit ?,?";
        return jdbcTemplate.query(sql, new Object[]{startPage,perPage}, new int[]{Types.INTEGER,Types.INTEGER}, new NoticeRowMapper());
    }
    
    @Override
    public int getNoticeCount() {
        String sql = "select count(*) from core_notice";
        return jdbcTemplate.queryForInt(sql);
    }

    class NoticeRowMapper implements RowMapper<Notice>{

        @Override
        public Notice mapRow(ResultSet rs, int index) throws SQLException {
            Notice notice = new Notice();
            notice.setId(rs.getInt("nid"));
            notice.setTitle(rs.getString("notice_title"));
            notice.setContent(rs.getString("notice_content"));
            notice.setCreateTime(rs.getTimestamp("notice_time"));
            return notice;
        }
        
    }


}
