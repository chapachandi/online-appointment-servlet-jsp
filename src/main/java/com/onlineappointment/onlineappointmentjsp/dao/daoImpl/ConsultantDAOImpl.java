package com.onlineappointment.onlineappointmentjsp.dao.daoImpl;

import com.onlineappointment.onlineappointmentjsp.dao.ConsultantDAO;
import com.onlineappointment.onlineappointmentjsp.db.DBConnectionFactory;
import com.onlineappointment.onlineappointmentjsp.entity.Consultant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultantDAOImpl implements ConsultantDAO {
    @Override
    public List<Consultant> getAllConsultants() {
        List<Consultant> consultants = new ArrayList<>();
        try (Connection connection = DBConnectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM consultants")) {

            while (resultSet.next()) {
                Consultant consultant = resultSetToConsultant(resultSet);
                consultants.add(consultant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultants;
    }

    @Override
    public Consultant getConsultantById(int id) {
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM consultants WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSetToConsultant(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Consultant getConsultantByUsername(String username) {
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM consultants WHERE username = ?")) {

            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSetToConsultant(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Consultant> getConsultantsByUserType(String userType) {
        List<Consultant> consultants = new ArrayList<>();
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM consultants WHERE user_type = ?")) {

            preparedStatement.setString(1, userType);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Consultant consultant = resultSetToConsultant(resultSet);
                    consultants.add(consultant);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultants;
    }

    @Override
    public void addConsultant(Consultant consultant) {
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO consultants (name, email, number, user_type, job_type, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, consultant.getName());
            preparedStatement.setString(2, consultant.getEmail());
            preparedStatement.setString(3, consultant.getNumber());
            preparedStatement.setString(4, consultant.getUserType());
            preparedStatement.setString(5, consultant.getJobType());
            preparedStatement.setString(6, consultant.getUsername());
            preparedStatement.setString(7, consultant.getPassword());

            preparedStatement.executeUpdate();

            // Retrieve the generated ID (if needed)
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    consultant.setId(Long.valueOf(id));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateConsultant(Consultant consultant) {
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE consultants SET name = ?, email = ?, number = ?, user_type = ?, job_type = ?, username = ?, password = ? WHERE id = ?")) {

            preparedStatement.setString(1, consultant.getName());
            preparedStatement.setString(2, consultant.getEmail());
            preparedStatement.setString(3, consultant.getNumber());
            preparedStatement.setString(4, consultant.getUserType());
            preparedStatement.setString(5, consultant.getJobType());
            preparedStatement.setString(6, consultant.getUsername());
            preparedStatement.setString(7, consultant.getPassword());
            preparedStatement.setInt(8, Math.toIntExact(consultant.getId()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteConsultant(int id) {
        try (Connection connection = DBConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM consultants WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Consultant resultSetToConsultant(ResultSet resultSet) throws SQLException {
        Consultant consultant = new Consultant();
        consultant.setId(Long.valueOf(resultSet.getInt("id")));
        consultant.setName(resultSet.getString("name"));
        consultant.setEmail(resultSet.getString("email"));
        consultant.setNumber(resultSet.getString("number"));
        consultant.setUserType(resultSet.getString("user_type"));
        consultant.setJobType(resultSet.getString("job_type"));
        consultant.setUsername(resultSet.getString("username"));
        consultant.setPassword(resultSet.getString("password"));
        return consultant;
    }
}
