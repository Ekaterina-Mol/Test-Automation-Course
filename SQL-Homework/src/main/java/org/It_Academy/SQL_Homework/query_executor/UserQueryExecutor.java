package org.It_Academy.SQL_Homework.query_executor;

import org.It_Academy.SQL_Homework.model.Account;
import org.It_Academy.SQL_Homework.model.User;

import java.sql.*;

import static java.lang.String.format;

public class UserQueryExecutor {
    private static final String JDBC_DRIVER_PATH = "org.sqlite.JDBC";
    private final String DATABASE_URL =
            "jdbc:sqlite:C:\\Users\\Admin\\Downloads\\sqlitestudio-3.3.3\\SQLiteStudio\\IT_ACADEMY_DATABASE.db";
    private Connection connection = null;
    private JDBCConnectionFactory jdbcConnectionFactory;

    public UserQueryExecutor() {
        this.jdbcConnectionFactory = new JDBCConnectionFactory();
    }

    public User getUser(int id) throws SQLException {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        User resultUser;
        try {
            this.connection = this.jdbcConnectionFactory.getConnection();
            statement =
                    connection.prepareStatement(format("SELECT * FROM Users WHERE userId = '%d';", id));
            resultSet = statement.executeQuery();

            resultUser = new User();
            while (resultSet.next()) {
                resultUser.setUserId(resultSet.getInt("userId"));
                resultUser.setAddress(resultSet.getString("address"));
                resultUser.setName(resultSet.getString("name"));
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                this.connection.close();
            }
        }

        return resultUser;
    }

    public void addUser(User user) throws SQLException {
        Statement statement = null;
        try {
            this.connection = this.jdbcConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(format("INSERT INTO Users (userId, name, address) VALUES('%d', '%s', '%s')",
                    user.getUserId(), user.getName(), user.getAddress()));
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                this.connection.close();
            }
        }
    }
}
