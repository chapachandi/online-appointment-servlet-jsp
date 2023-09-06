package com.onlineappointment.onlineappointmentjsp.servlet;

import com.onlineappointment.onlineappointmentjsp.entity.Appointment;
import com.onlineappointment.onlineappointmentjsp.service.AppointmentService;
import com.onlineappointment.onlineappointmentjsp.service.serviceImpl.AppointmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/appointments")
public class AppointmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AppointmentService appointmentService;

    public AppointmentServlet() {
        // Initialize the AppointmentService (you should inject it using a framework)
        this.appointmentService = new AppointmentServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("list".equals(action)) {
            listAppointments(request, response);
        } else {
            // Default action, list appointments
            listAppointments(request, response);
        }
    }

    private void listAppointments(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve appointments from the service
        List<Appointment> appointments = appointmentService.getAllAppointments();

        // Set the appointments as an attribute in the request
        request.setAttribute("appointments", appointments);

        // Forward to the appointments list view (e.g., JSP page)
        request.getRequestDispatcher("/appointments-list.jsp").forward(request, response);
    }

}
