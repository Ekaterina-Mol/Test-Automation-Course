package org.It_Academy.SQL_Homework.query_executor;
import org.It_Academy.SQL_Homework.model.Transaction;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.String.format;
public class TransactionQueryExecutor {
    private Connection connection = null;
    private JDBCConnectionFactory jdbcConnectionFactory;

    public TransactionQueryExecutor() {
        this.jdbcConnectionFactory = new JDBCConnectionFactory();
    }

    public void addTransaction(Transaction transaction) throws SQLException {
        Statement statement = null;
        try {
            this.connection = this.jdbcConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(format("INSERT INTO Transactions (transactionID, accountId, amount) VALUES('%d', '%d', '%d')",
                    transaction.getTransactionId(), transaction.getAccountId(), transaction.getAmount()));
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
