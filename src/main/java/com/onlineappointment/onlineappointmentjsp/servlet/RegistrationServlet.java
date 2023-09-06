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
        super.init();
        // Initialize the RegistrationDAO using the DAO implementation
        registrationDAO = new RegistrationDAOImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String number = request.getParameter("number");
        String userType = request.getParameter("userType");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Create a Registration object with the form data
        Registration registration = new Registration();
        registration.setName(name);
        registration.setEmail(email);
        registration.setNumber(number);
        registration.setUserType(userType);
        registration.setUsername(username);
        registration.setPassword(password);

        // Add the registration to the database
        registrationDAO.addRegistration(registration);

        // Redirect to a success page or login page
        response.sendRedirect("/login.jsp");
    }
}
