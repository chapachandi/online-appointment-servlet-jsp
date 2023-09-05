package com.onlineappointment.onlineappointmentjsp.servlet;

import com.onlineappointment.onlineappointmentjsp.dao.RegistrationDAO;
import com.onlineappointment.onlineappointmentjsp.dao.daoImpl.RegistrationDAOImpl;
import com.onlineappointment.onlineappointmentjsp.entity.Registration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private RegistrationDAO registrationDAO;

    @Override
    public void init() throws ServletException {

         EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistence");
         EntityManager em = emf.createEntityManager();
         registrationDAO = new RegistrationDAOImpl(em);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String userType = request.getParameter("userType");
        String password = request.getParameter("password");

        // Create a RegistrationEntity object with the user's information
        Registration registration = new Registration();
        registration.setUsername(username);
        registration.setEmail(email);
        registration.setPhoneNumber(phoneNumber);
        registration.setUserType(userType);
        registration.setPassword(password);

        // Save the user registration record to the database
        registrationDAO.save(registration);

        // Redirect to a success page or perform other actions
        response.sendRedirect("/login.jsp");
    }
}

