package com.sheepfly.springpro.chapter6.daos;

import com.sheepfly.springpro.chapter6.entities.Singer;
import com.sheepfly.springpro.chapter6.exceptions.CoreRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlainSingerDao implements SingerDao {
    private static final Logger logger = LoggerFactory.getLogger(PlainSingerDao.class);
    private static final String username = "commonuser";
    private static final String password = "commonuser";
    private static final String url = "jdbc:mysql://localhost:3306";
    private static final String driver = "com.mysql.cj.jdbc.driver";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            logger.error("Prblem loadng DB dDiver!", ex);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    private void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException ex) {
            logger.error("Problem closing connection to the database!", ex);
        }
    }

    @Override
    public List<Singer> findAll() {
        List<Singer> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("select * from musicdb.singer");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Singer singer = new Singer();
                singer.setId(resultSet.getLong("id"));
                singer.setFirstName(resultSet.getString("first_name"));
                singer.setLastName(resultSet.getString("last_name"));
                singer.setBirthDate(resultSet.getDate("birth_date"));
                result.add(singer);
            }
            statement.close();
        } catch (SQLException ex) {
            logger.error("Problem when executing SELECT!", ex);
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public void insert(Singer singer) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "insert into musicdb.Singer (first_name, last_name, birth_date) values (?, ?, ?)"
                    , Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, singer.getFirstName());
            statement.setString(2, singer.getLastName());
            statement.setDate(3, singer.getBirthDate());
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                singer.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException ex) {
            logger.error("Prblem executing INSERT", ex);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void delete(Long singerId) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from musicdb.singer where id=?");
            statement.setLong(1, singerId);
            statement.execute();
        } catch (SQLException ex) {
            logger.error("Prblem executing DELETE", ex);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        throw new CoreRuntimeException("findByFirstName");
    }

    @Override
    public String findFirstNameById(Long id) {
        throw new CoreRuntimeException("findFirstNameById");
    }

    @Override
    public String findLastNameById(Long id) {
        throw new CoreRuntimeException("findLastNameById");
    }

    @Override
    public void update(Singer singer) {
        throw new CoreRuntimeException("update");
    }

    @Override
    public List<Singer> findAllWithAlbums() {
        throw new CoreRuntimeException("findAllWithAlbums");
    }

    @Override
    public void insertWithAlbum(Singer singer) {
        throw new CoreRuntimeException("insertWithAlbum");
    }

    @Override
    public String findNameById(Long id) {
        throw new CoreRuntimeException("findNameById");
    }
}
