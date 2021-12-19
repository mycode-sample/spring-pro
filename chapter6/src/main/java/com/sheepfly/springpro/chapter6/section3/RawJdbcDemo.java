package com.sheepfly.springpro.chapter6.section3;

import com.sheepfly.springpro.chapter6.daos.PlainSingerDao;
import com.sheepfly.springpro.chapter6.entities.Singer;
import com.sheepfly.springpro.chapter6.exceptions.CoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class RawJdbcDemo {
    private static final Logger log = LoggerFactory.getLogger(RawJdbcDemo.class);
    private static final String username = "commonuser";
    private static final String password = "commonuser";
    private static final String url = "jdbc:mysql://localhost:3306";
    private static final String driver = "com.mysql.cj.jdbc.driver";
    private static Connection connection;

    public static void main(String[] args) {
        PlainSingerDao dao = new PlainSingerDao();
        List<Singer> list = dao.findAll();
        log.info(String.valueOf(list.size()));
    }

    public static Connection getConnection() throws CoreException {
        if (connection == null) {
            try {
                Class.forName(driver);
                DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException e) {
                throw new CoreException("加载数据库驱动失败", e);
            } catch (SQLException sqlException) {
                throw new CoreException("获取数据库连接失败", sqlException);
            }
        }
        return connection;
    }

    public static void closeConnection() throws CoreException {
        if (connection == null) {
            throw new CoreException("关闭连接失败:连接不存在");
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new CoreException("关闭连接失败", e);
        }
    }
}
