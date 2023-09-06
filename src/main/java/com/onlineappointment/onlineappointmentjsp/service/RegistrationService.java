package com.onlineappointment.onlineappointmentjsp.service;

import com.onlineappointment.onlineappointmentjsp.entity.Registration;

import java.util.List;

public interface RegistrationService {
    void addRegistration(Registration registration);

    Registration getRegistrationById(int id);

    Registration getRegistrationByUsername(String username);

    List<Registration> getAllRegistrations();

    void updateRegistration(Registration registration);

    void deleteRegistration(int id);
}
