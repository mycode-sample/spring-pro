package com.sheepfly.springpro.chapter6.section5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConfigDemo {
    private static final Logger log = LoggerFactory.getLogger(DBConfigDemo.class);

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfig.class);
        DBConfig dbConfig = ctx.getBean("DBConfig", DBConfig.class);
        DataSource dataSource = dbConfig.getDataSource();
        System.out.println(dataSource.toString());
        Connection connection;
        try {
            connection = dbConfig.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            log.error("发生异常", e);
        }
        log.info("测试完成");
    }
}
