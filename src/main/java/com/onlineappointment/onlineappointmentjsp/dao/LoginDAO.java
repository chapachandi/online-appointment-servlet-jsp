package com.onlineappointment.onlineappointmentjsp.dao;

import com.onlineappointment.onlineappointmentjsp.entity.Login;

import java.util.Optional;

public interface LoginDAO {
    boolean authenticate(String username, String password, String userType);
}
