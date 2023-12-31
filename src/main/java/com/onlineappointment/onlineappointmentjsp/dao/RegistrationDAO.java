package com.onlineappointment.onlineappointmentjsp.dao;

import com.onlineappointment.onlineappointmentjsp.entity.Registration;

import java.util.List;
import java.util.Optional;

public interface RegistrationDAO {
    void addRegistration(Registration registration);

    Registration getRegistrationById(int id);

    Registration getRegistrationByUsername(String username);

    List<Registration> getAllRegistrations();

    void updateRegistration(Registration registration);

    void deleteRegistration(int id);
}
