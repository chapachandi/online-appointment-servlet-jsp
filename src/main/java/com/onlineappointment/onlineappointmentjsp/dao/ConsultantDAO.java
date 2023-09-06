package com.onlineappointment.onlineappointmentjsp.dao;

import com.onlineappointment.onlineappointmentjsp.entity.Consultant;

import java.util.List;

public interface ConsultantDAO {
    List<Consultant> getAllConsultants();
    Consultant getConsultantById(int id);

    Consultant getConsultantByUsername(String username);

    List<Consultant> getConsultantsByUserType(String userType);

    void addConsultant(Consultant consultant);
    void updateConsultant(Consultant consultant);
    void deleteConsultant(int id);
}
