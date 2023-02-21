package com.sheepfly.springpro.chapter6.section9;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Component
public class SqliteSimpleDaoImpl implements SimpleDao {
    @Resource(name = "sqliteDataSource")
    private DataSource dataSource;
    @Resource(name = "sqliteJdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Resource(name = "sqliteNamedJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Map<String, Object>> queryById(String id) {
        return null;
    }

    @Override
    public Map<String, Object> queryOneByName(String name) {
        return null;
    }

    @Override
    public List<Map> queryAllList() {
        return null;
    }
}
