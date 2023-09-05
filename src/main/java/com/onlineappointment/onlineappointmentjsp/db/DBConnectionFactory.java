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
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

