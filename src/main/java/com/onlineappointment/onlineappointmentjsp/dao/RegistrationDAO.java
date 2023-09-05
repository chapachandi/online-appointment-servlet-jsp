package com.onlineappointment.onlineappointmentjsp.dao;

import com.onlineappointment.onlineappointmentjsp.entity.Registration;

import java.util.List;
import java.util.Optional;

public interface RegistrationDAO {
    // Save a new user registration record
    void save(Registration registration);

    // Update an existing user registration record
    void update(Registration registration);

    // Delete a user registration record by ID
    void deleteById(Long id);

    // Find a user registration record by ID
    Optional<Registration> findById(Long id);

    // Find a user registration record by username
    Optional<Registration> findByUsername(String username);

    // Get a list of all user registration records
    List<Registration> findAll();
}
