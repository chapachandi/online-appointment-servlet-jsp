package com.onlineappointment.onlineappointmentjsp.servlet;

import com.onlineappointment.onlineappointmentjsp.dao.LoginDAO;
import com.onlineappointment.onlineappointmentjsp.dao.daoImpl.LoginDAOImpl;
import com.onlineappointment.onlineappointmentjsp.entity.Login;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private LoginDAO loginDAO;

    @Override
    public void init() throws ServletException {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistence");
         EntityManager em = emf.createEntityManager();
         loginDAO = new LoginDAOImpl(em);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");

        Optional<Login> loginInfo = loginDAO.findByUsernameAndPasswordAndUserType(username, password, userType);

        if (loginInfo.isPresent()) {
            // Authentication successful
            // Redirect to the appropriate dashboard based on user type
            if ("admin".equals(userType)) {
                // Redirect to admin dashboard
                response.sendRedirect("/admin-dashboard.jsp");
            } else if ("consultant".equals(userType)) {
                // Redirect to consultant dashboard
                response.sendRedirect("/consultant-dashboard.jsp");
            } else if ("user".equals(userType)) {
                // Redirect to user dashboard
                response.sendRedirect("/user-dashboard.jsp");
            }
        } else {
            // Authentication failed, handle accordingly
            response.sendRedirect("/login.jsp?error=true");
        }
    }
}
