package com.sheepfly.springpro.chapter6.section9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SimpleDaoImpl implements SimpleDao {
    private static final Logger log = LoggerFactory.getLogger(SimpleDaoImpl.class);

    @Resource(name = "dataSource")
    private DataSource dataSource;
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Resource(name = "namedJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Map<String, Object>> queryById(String id) {
        String sql = "select * from musicdb.singer where id = ?";
        return jdbcTemplate.queryForList(sql, id);
    }

    @Override
    public Map<String, Object> queryOneByName(String name) {
        String sql = "select first_name from musicdb.singer where first_name = :name";
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        String singerName = namedParameterJdbcTemplate.queryForObject(sql, map, String.class);
        Map<String, Object> result = new HashMap<>();
        result.put("singerName", singerName);
        return result;
    }

    @Override
    public List<Map> queryAllList() {
        String sql = "select * from musicdb.singer";
        List<Map> result = jdbcTemplate.query(sql, new SingerMapRowMapper());
        return result;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private static class SingerMapRowMapper implements RowMapper<Map> {
        @Override
        public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
            Map<String, Object> map = new HashMap<>();
            map.put("ID", rs.getInt("ID"));
            map.put("FIRST_NAME", rs.getString("FIRST_NAME"));
            map.put("LAST_NAME", rs.getString("LAST_NAME"));
            map.put("BIRTH_DATE", rs.getDate("BIRTH_DATE"));
            return map;
        }
    }
}
