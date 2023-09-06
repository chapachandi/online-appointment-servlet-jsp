package com.onlineappointment.onlineappointmentjsp.dao;

import com.onlineappointment.onlineappointmentjsp.entity.Appointment;

import java.util.List;

public interface AppointmentDAO {
    void saveAppointment(Appointment appointment);
    List<Appointment> getAppointmentsByJobSeeker(Long jobSeekerId);
    void approveAppointment(Long appointmentId);

    List<Appointment> getAllAppointments();
}
