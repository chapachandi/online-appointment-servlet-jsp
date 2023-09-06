package com.onlineappointment.onlineappointmentjsp.dao.daoImpl;

import com.onlineappointment.onlineappointmentjsp.dao.AppointmentDAO;
import com.onlineappointment.onlineappointmentjsp.entity.Appointment;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {
    private EntityManager entityManager;

    public AppointmentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveAppointment(Appointment appointment) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(appointment);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Appointment> getAppointmentsByJobSeeker(Long jobSeekerId) {
        String jpql = "SELECT a FROM Appointment a WHERE a.jobSeeker.id = :jobSeekerId";
        Query query = entityManager.createQuery(jpql, Appointment.class);
        query.setParameter("jobSeekerId", jobSeekerId);
        return query.getResultList();
    }

    @Override
    public void approveAppointment(Long appointmentId) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Appointment appointment = entityManager.find(Appointment.class, appointmentId);
            if (appointment != null) {
                appointment.setApproved(true);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public List<Appointment> getAllAppointments() {
        // Implement the database query to retrieve all appointments
        // Return a list of Appointment objects
        return null; // Replace with your database query logic
    }
}
