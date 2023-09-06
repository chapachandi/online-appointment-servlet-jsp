package com.onlineappointment.onlineappointmentjsp.service.serviceImpl;

import com.onlineappointment.onlineappointmentjsp.dao.AppointmentDAO;
import com.onlineappointment.onlineappointmentjsp.entity.Appointment;
import com.onlineappointment.onlineappointmentjsp.service.AppointmentService;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentDAO appointmentDAO;

    public AppointmentServiceImpl() {
        this.appointmentDAO = appointmentDAO;
    }

    @Override
    public void scheduleAppointment(Appointment appointment) {
        // Implement scheduling logic, e.g., validation
        // You can add more validation as needed
        if (isValidAppointment(appointment)) {
            appointmentDAO.saveAppointment(appointment);
        } else {
            throw new IllegalArgumentException("Invalid appointment details");
        }
    }

    private boolean isValidAppointment(Appointment appointment) {
        return false;
    }

    @Override
    public List<Appointment> getAppointmentsByJobSeeker(Long jobSeekerId) {
        // Implement logic to retrieve appointments for a job seeker
        return appointmentDAO.getAppointmentsByJobSeeker(jobSeekerId);
    }

    @Override
    public void approveAppointment(Long appointmentId) {
        // Implement logic to approve an appointment
        appointmentDAO.approveAppointment(appointmentId);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }
}
