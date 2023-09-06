package com.onlineappointment.onlineappointmentjsp.dao.daoImpl;

import com.onlineappointment.onlineappointmentjsp.dao.LoginDAO;
import com.onlineappointment.onlineappointmentjsp.db.DBConnectionFactory;
import com.onlineappointment.onlineappointmentjsp.entity.Login;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class LoginDAOImpl implements LoginDAO {
    private static final String SELECT_USER_QUERY = "SELECT * FROM users WHERE username = ? AND password = ? AND user_type = ?";

    @Override
    public boolean authenticate(String username, String password, String userType) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish a database connection using DBConnectionFactory
            connection = DBConnectionFactory.getConnection();

            // Create a SQL query to retrieve the user based on provided credentials and user type
            preparedStatement = connection.prepareStatement(SELECT_USER_QUERY);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, userType);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // If a matching user is found, authentication is successful
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Authentication failed due to an error
        } finally {
            // Close database resources
            DBConnectionFactory.closeResultSet(resultSet);
            DBConnectionFactory.closeStatement(preparedStatement);
            DBConnectionFactory.closeConnection(connection);
        }
    }
}
