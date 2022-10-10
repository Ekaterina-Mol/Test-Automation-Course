package org.It_Academy.SQL_Homework.query_executor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionFactory implements AutoCloseable {
    private final String JDBC_DRIVER_PATH = "org.sqlite.JDBC";
    private final String DATABASE_URL =
            "jdbc:sqlite:C:\\Users\\Admin\\Downloads\\sqlitestudio-3.3.3\\SQLiteStudio\\IT_ACADEMY_DATABASE.db";
    private Connection connection;

    public Connection getConnection() throws SQLException {
        if(isDriverExists()) {
            if(this.connection == null || this.connection.isClosed()) {
                this.connection = DriverManager.getConnection(DATABASE_URL);
            }
        } else {
            throw new RuntimeException();
        }

        return this.connection;
    }

    @Override
    public void close() throws Exception {
        this.closeConnection();
    }

    private void closeConnection() throws SQLException {
        if (!this.connection.isClosed()) {
            this.connection.close();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        this.close();
        super.finalize();
    }

    private boolean isDriverExists() {
        try {
            Class.forName(JDBC_DRIVER_PATH);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBC Driver was not found");
            return false;
        }
    }
}
