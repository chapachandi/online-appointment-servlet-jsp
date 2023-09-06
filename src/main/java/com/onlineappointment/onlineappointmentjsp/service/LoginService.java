package com.onlineappointment.onlineappointmentjsp.service;

public interface LoginService {
    boolean authenticate(String username, String password, String userType);
}
