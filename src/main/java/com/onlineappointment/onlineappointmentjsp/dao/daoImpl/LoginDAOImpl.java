package com.onlineappointment.onlineappointmentjsp.dao.daoImpl;

import com.onlineappointment.onlineappointmentjsp.dao.LoginDAO;
import com.onlineappointment.onlineappointmentjsp.entity.Login;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class LoginDAOImpl implements LoginDAO {
    private final EntityManager entityManager;

    public LoginDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Login> findByUsernameAndPasswordAndUserType(String username, String password, String userType) {
        try {
            TypedQuery<Login> query = entityManager.createQuery(
                    "SELECT l FROM Login l WHERE l.username = :username " +
                            "AND l.password = :password " +
                            "AND l.userType = :userType",
                    Login.class
            );
            query.setParameter("username", username);
            query.setParameter("password", password);
            query.setParameter("userType", userType);

            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
