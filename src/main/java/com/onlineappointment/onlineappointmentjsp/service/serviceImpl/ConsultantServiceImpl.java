package com.onlineappointment.onlineappointmentjsp.service.serviceImpl;

import com.onlineappointment.onlineappointmentjsp.dao.ConsultantDAO;
import com.onlineappointment.onlineappointmentjsp.dao.daoImpl.ConsultantDAOImpl;
import com.onlineappointment.onlineappointmentjsp.entity.Consultant;
import com.onlineappointment.onlineappointmentjsp.service.ConsultantService;

import java.util.List;

public class ConsultantServiceImpl implements ConsultantService {
    private final ConsultantDAO consultantDAO = new ConsultantDAOImpl();

    @Override
    public List<Consultant> getAllConsultants() {
        return consultantDAO.getAllConsultants();
    }

    @Override
    public Consultant getConsultantById(int id) {
        return consultantDAO.getConsultantById(id);
    }

    @Override
    public Consultant getConsultantByUsername(String username) {
        return consultantDAO.getConsultantByUsername(username);
    }

    @Override
    public List<Consultant> getConsultantsByUserType(String userType) {
        return consultantDAO.getConsultantsByUserType(userType);
    }

    @Override
    public void addConsultant(Consultant consultant) {
        consultantDAO.addConsultant(consultant);
    }

    @Override
    public void updateConsultant(Consultant consultant) {
        consultantDAO.updateConsultant(consultant);
    }

    @Override
    public void deleteConsultant(int id) {
        consultantDAO.deleteConsultant(id);
    }


}
