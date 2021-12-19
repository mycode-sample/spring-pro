package com.sheepfly.springpro.chapter6.section5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:section5/datasource.properties")
public class DBConfig {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.driver}")
    private String driver;

    private DriverManagerDataSource dataSource;
    private List<Connection> connectionList;

    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean("dataSource")
    public DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new DriverManagerDataSource();
        }
        if (connectionList == null) {
            connectionList = new ArrayList<>();
        }
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
    }

    public Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        connectionList.add(connection);
        return connection;
    }
}
