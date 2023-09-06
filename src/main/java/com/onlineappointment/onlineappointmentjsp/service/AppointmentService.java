package com.onlineappointment.onlineappointmentjsp.service;

import com.onlineappointment.onlineappointmentjsp.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    void scheduleAppointment(Appointment appointment);
    List<Appointment> getAppointmentsByJobSeeker(Long jobSeekerId);
    void approveAppointment(Long appointmentId);
    List<Appointment> getAllAppointments();
}
