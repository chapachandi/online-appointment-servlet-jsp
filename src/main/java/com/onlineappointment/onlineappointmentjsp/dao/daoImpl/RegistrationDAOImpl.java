package com.onlineappointment.onlineappointmentjsp.dao.daoImpl;

import com.onlineappointment.onlineappointmentjsp.dao.RegistrationDAO;
import com.onlineappointment.onlineappointmentjsp.db.DBConnectionFactory;
import com.onlineappointment.onlineappointmentjsp.entity.Registration;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {

    @Override
    public void addRegistration(Registration registration) {
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO registrations (name, email, number, user_type, username, password) " +
                             "VALUES (?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, registration.getName());
            preparedStatement.setString(2, registration.getEmail());
            preparedStatement.setString(3, registration.getNumber());
            preparedStatement.setString(4, registration.getUserType());
            preparedStatement.setString(5, registration.getUsername());
            preparedStatement.setString(6, registration.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Registration getRegistrationById(int id) {
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM registrations WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return mapResultSetToRegistration(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Registration getRegistrationByUsername(String username) {
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM registrations WHERE username = ?")) {

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return mapResultSetToRegistration(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Registration> getAllRegistrations() {
        List<Registration> registrations = new ArrayList<>();

        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM registrations")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                registrations.add(mapResultSetToRegistration(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registrations;
    }

    @Override
    public void updateRegistration(Registration registration) {
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE registrations SET name = ?, email = ?, number = ?, user_type = ?, username = ?, password = ? " +
                             "WHERE id = ?")) {

            preparedStatement.setString(1, registration.getName());
            preparedStatement.setString(2, registration.getEmail());
            preparedStatement.setString(3, registration.getNumber());
            preparedStatement.setString(4, registration.getUserType());
            preparedStatement.setString(5, registration.getUsername());
            preparedStatement.setString(6, registration.getPassword());
            preparedStatement.setInt(7, Math.toIntExact(registration.getId()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRegistration(int id) {
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM registrations WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Helper method to map ResultSet to Registration object
    private Registration mapResultSetToRegistration(ResultSet resultSet) throws SQLException {
        Registration registration = new Registration();
        registration.setId(Long.valueOf(resultSet.getInt("id")));
        registration.setName(resultSet.getString("name"));
        registration.setEmail(resultSet.getString("email"));
        registration.setNumber(resultSet.getString("number"));
        registration.setUserType(resultSet.getString("user_type"));
        registration.setUsername(resultSet.getString("username"));
        registration.setPassword(resultSet.getString("password"));
        return registration;
    }
}
