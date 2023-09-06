package com.onlineappointment.onlineappointmentjsp.service.serviceImpl;

import com.onlineappointment.onlineappointmentjsp.dao.LoginDAO;
import com.onlineappointment.onlineappointmentjsp.dao.daoImpl.LoginDAOImpl;
import com.onlineappointment.onlineappointmentjsp.service.LoginService;

public class LoginServiceImpl implements LoginService {
    private LoginDAO loginDAO;

    public LoginServiceImpl() {
        // Initialize the loginDAO with an instance of LoginDAOImpl
        loginDAO = new LoginDAOImpl();
    }

    @Override
    public boolean authenticate(String username, String password, String userType) {
        // Implement custom authentication logic here
        // You can add business rules based on user type
        if ("admin".equals(userType)) {
            // Business rules for admin authentication (e.g., additional checks)
            return loginDAO.authenticate(username, password, userType);
        } else if ("consultant".equals(userType)) {
            // Business rules for consultant authentication (e.g., additional checks)
            return loginDAO.authenticate(username, password, userType);
        } else if ("user".equals(userType)) {
            // Business rules for user authentication (e.g., additional checks)
            return loginDAO.authenticate(username, password, userType);
        } else {
            // Invalid user type
            return false;
        }
    }
}
