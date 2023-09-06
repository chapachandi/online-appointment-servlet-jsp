package com.onlineappointment.onlineappointmentjsp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionFactory {
    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/online_appointment";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "chapa";

    // Create a database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static void close(Connection connection, AutoCloseable... closeables) {
        try {
            if (connection != null) {
                connection.close();
            }
            for (AutoCloseable closeable : closeables) {
                if (closeable != null) {
                    closeable.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

