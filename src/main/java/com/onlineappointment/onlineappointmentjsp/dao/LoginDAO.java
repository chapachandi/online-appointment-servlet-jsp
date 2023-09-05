package com.onlineappointment.onlineappointmentjsp.dao;

import com.onlineappointment.onlineappointmentjsp.entity.Login;

import java.util.Optional;

public interface LoginDAO {
    Optional<Login> findByUsernameAndPasswordAndUserType(String username, String password, String userType);
}
