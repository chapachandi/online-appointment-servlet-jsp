package com.onlineappointment.onlineappointmentjsp.dao.daoImpl;

import com.onlineappointment.onlineappointmentjsp.dao.JobDAO;
import com.onlineappointment.onlineappointmentjsp.db.DBConnectionFactory;
import com.onlineappointment.onlineappointmentjsp.entity.Job;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobDAOImpl implements JobDAO {


    @Override
    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnectionFactory.getConnection();
            String query = "SELECT * FROM jobs";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Job job = new Job();
                job.setId(Long.valueOf(resultSet.getInt("id")));
                job.setCountry(resultSet.getString("country"));
                job.setJobTitle(resultSet.getString("job_title"));
                job.setJobType(resultSet.getString("job_type"));
                job.setLocation(resultSet.getString("location"));
                job.setPublishedDate(new Date(resultSet.getTimestamp("published_date").getTime()));
                job.setDescription(resultSet.getString("description"));
                jobs.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionFactory.close(connection, preparedStatement, resultSet);
        }

        return jobs;
    }

    @Override
    public Job getJobById(int id) {
        Job job = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnectionFactory.getConnection();
            String query = "SELECT * FROM jobs WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                job = new Job();
                job.setId(Long.valueOf(resultSet.getInt("id")));
                job.setCountry(resultSet.getString("country"));
                job.setJobTitle(resultSet.getString("job_title"));
                job.setJobType(resultSet.getString("job_type"));
                job.setLocation(resultSet.getString("location"));
                job.setPublishedDate(new Date(resultSet.getTimestamp("published_date").getTime()));
                job.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionFactory.close(connection, preparedStatement, resultSet);
        }

        return job;
    }

    @Override
    public void addJob(Job job) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnectionFactory.getConnection();
            String query = "INSERT INTO jobs (country, job_title, job_type, location, published_date, description) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, job.getCountry());
            preparedStatement.setString(2, job.getJobTitle());
            preparedStatement.setString(3, job.getJobType());
            preparedStatement.setString(4, job.getLocation());
            preparedStatement.setTimestamp(5, new java.sql.Timestamp(job.getPublishedDate().getTime()));
            preparedStatement.setString(6, job.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionFactory.close(connection, preparedStatement);
        }
    }

    @Override
    public void updateJob(Job job) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnectionFactory.getConnection();
            String query = "UPDATE jobs SET country = ?, job_title = ?, job_type = ?, location = ?, " +
                    "published_date = ?, description = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, job.getCountry());
            preparedStatement.setString(2, job.getJobTitle());
            preparedStatement.setString(3, job.getJobType());
            preparedStatement.setString(4, job.getLocation());
            preparedStatement.setTimestamp(5, new java.sql.Timestamp(job.getPublishedDate().getTime()));
            preparedStatement.setString(6, job.getDescription());
            preparedStatement.setInt(7, Math.toIntExact(job.getId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionFactory.close(connection, preparedStatement);
        }
    }

    @Override
    public void deleteJob(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBConnectionFactory.getConnection();
            String query = "DELETE FROM jobs WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionFactory.close(connection, preparedStatement);
        }
    }

    @Override
    public List<Job> searchJobsByCountryAndType(String country, String jobType) {
        List<Job> jobs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnectionFactory.getConnection();
            String query = "SELECT * FROM jobs WHERE country = ? AND job_type = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, country);
            preparedStatement.setString(2, jobType);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Job job = new Job();
                job.setId(Long.valueOf(resultSet.getInt("id")));
                job.setCountry(resultSet.getString("country"));
                job.setJobTitle(resultSet.getString("job_title"));
                job.setJobType(resultSet.getString("job_type"));
                job.setLocation(resultSet.getString("location"));
                job.setPublishedDate(new Date(resultSet.getTimestamp("published_date").getTime()));
                job.setDescription(resultSet.getString("description"));
                jobs.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnectionFactory.close(connection, preparedStatement, resultSet);
        }

        return jobs;
    }

}

