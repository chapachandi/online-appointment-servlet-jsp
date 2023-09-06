package com.onlineappointment.onlineappointmentjsp.service.serviceImpl;

import com.onlineappointment.onlineappointmentjsp.dao.RegistrationDAO;
import com.onlineappointment.onlineappointmentjsp.dao.daoImpl.RegistrationDAOImpl;
import com.onlineappointment.onlineappointmentjsp.entity.Registration;
import com.onlineappointment.onlineappointmentjsp.service.RegistrationService;

import java.util.List;

public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationDAO registrationDAO = new RegistrationDAOImpl();

    @Override
    public void addRegistration(Registration registration) {
        registrationDAO.addRegistration(registration);
    }

    @Override
    public Registration getRegistrationById(int id) {
        return registrationDAO.getRegistrationById(id);
    }

    @Override
    public Registration getRegistrationByUsername(String username) {
        return registrationDAO.getRegistrationByUsername(username);
    }

    @Override
    public List<Registration> getAllRegistrations() {
        return registrationDAO.getAllRegistrations();
    }

    @Override
    public void updateRegistration(Registration registration) {
        registrationDAO.updateRegistration(registration);
    }

    @Override
    public void deleteRegistration(int id) {
        registrationDAO.deleteRegistration(id);
    }
}
