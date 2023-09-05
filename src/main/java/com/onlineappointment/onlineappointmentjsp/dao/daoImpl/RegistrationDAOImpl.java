package com.onlineappointment.onlineappointmentjsp.dao.daoImpl;

import com.onlineappointment.onlineappointmentjsp.dao.RegistrationDAO;
import com.onlineappointment.onlineappointmentjsp.entity.Registration;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class RegistrationDAOImpl implements RegistrationDAO {
    private final EntityManager entityManager;

    public RegistrationDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Registration registration) {
        entityManager.getTransaction().begin();
        entityManager.persist(registration);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Registration registration) {
        entityManager.getTransaction().begin();
        entityManager.merge(registration);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        Registration registration = entityManager.find(Registration.class, id);
        if (registration != null) {
            entityManager.remove(registration);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Optional<Registration> findById(Long id) {
        Registration registration = entityManager.find(Registration.class, id);
        return Optional.ofNullable(registration);
    }

    @Override
    public Optional<Registration> findByUsername(String username) {
        try {
            TypedQuery<Registration> query = entityManager.createQuery(
                    "SELECT r FROM Registration r WHERE r.username = :username",
                    Registration.class
            );
            query.setParameter("username", username);
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Registration> findAll() {
        TypedQuery<Registration> query = entityManager.createQuery(
                "SELECT r FROM Registration r",
                Registration.class
        );
        return query.getResultList();
    }
}

