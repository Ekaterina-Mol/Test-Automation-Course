package org.It_Academy.SQL_Homework.query_executor;

import org.It_Academy.SQL_Homework.model.Account;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static java.lang.String.format;

public class AccountQueryExecutor {
    private Connection connection = null;
    private JDBCConnectionFactory jdbcConnectionFactory;


    public AccountQueryExecutor() {
        this.jdbcConnectionFactory = new JDBCConnectionFactory();
    }

    public Account getAccount(int id) throws SQLException {
        Account resultAccount = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            this.connection = this.jdbcConnectionFactory.getConnection();
            statement =
                    connection.prepareStatement(format("SELECT * FROM Accounts WHERE accountId = '%d';", id));
            resultSet = statement.executeQuery();


            while (resultSet.next()) {
                resultAccount = new Account();
                resultAccount.setUserId(resultSet.getInt("userId"));
                resultAccount.setAccountId(resultSet.getInt("accountId"));
                resultAccount.setCurrency(resultSet.getString("currency"));
                resultAccount.setBalance(resultSet.getInt("balance"));
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

        return resultAccount;
    }

    public List<Account> getAccountsForUser(int userId) throws SQLException {
        List<Account> resultAccountsList;
        ResultSet resultSet = null;
        PreparedStatement statement = null;

        try {
            this.connection = this.jdbcConnectionFactory.getConnection();
            statement =
                    connection.prepareStatement(format("SELECT * FROM Accounts WHERE userId = '%d';", userId));
            resultSet = statement.executeQuery();


            resultAccountsList = new LinkedList<Account>();
            while (resultSet.next()) {
                Account resultAccount = new Account();
                resultAccount.setUserId(resultSet.getInt("userId"));
                resultAccount.setAccountId(resultSet.getInt("accountId"));
                resultAccount.setCurrency(resultSet.getString("currency"));
                resultAccount.setBalance(resultSet.getInt("balance"));

                resultAccountsList.add(resultAccount);
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

        return resultAccountsList;
    }

    public void addAccount(Account account) throws SQLException {
        Statement statement = null;

        try {
            this.connection = this.jdbcConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(format("INSERT INTO Accounts (accountId, userId, balance, currency) VALUES('%d', '%d', '%d', '%s')",
                    account.getAccountId(), account.getUserId(), account.getBalance(), account.getCurrency()));
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                this.connection.close();
            }
        }
    }

    public void updateAccount(Account account) throws SQLException {
        Statement statement = null;

        try {
            this.connection = this.jdbcConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(format("UPDATE Accounts SET userId = '%d', balance = '%d', currency = '%s' WHERE accountId='%d'",
                    account.getUserId(), account.getBalance(), account.getCurrency(), account.getAccountId()));
            statement.close();
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
