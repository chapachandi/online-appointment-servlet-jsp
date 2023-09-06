package com.onlineappointment.onlineappointmentjsp.servlet;

import com.onlineappointment.onlineappointmentjsp.service.LoginService;
import com.onlineappointment.onlineappointmentjsp.service.serviceImpl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize the loginService with an instance of LoginServiceImpl
        loginService = new LoginServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");

        // Authenticate the user using the service layer
        boolean isAuthenticated = loginService.authenticate(username, password, userType);

        if (isAuthenticated) {
            // Redirect the user to the dashboard or appropriate page
            if ("user".equals(userType)) {
                response.sendRedirect("/user-dashboard.jsp");
            } else if ("consultant".equals(userType)) {
                response.sendRedirect("/consultant-dashboard.jsp");
            } else if ("admin".equals(userType)) {
                response.sendRedirect("/admin-dashboard.jsp");
            }
        } else {
            // Invalid credentials, redirect to the login page with an error message
            response.sendRedirect("/login.jsp?error=true");
        }
    }
}
