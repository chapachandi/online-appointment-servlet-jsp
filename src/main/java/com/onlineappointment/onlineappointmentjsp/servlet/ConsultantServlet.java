package com.onlineappointment.onlineappointmentjsp.servlet;

import com.onlineappointment.onlineappointmentjsp.entity.Consultant;
import com.onlineappointment.onlineappointmentjsp.service.ConsultantService;
import com.onlineappointment.onlineappointmentjsp.service.serviceImpl.ConsultantServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/consultants")
public class ConsultantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final ConsultantService consultantService = new ConsultantServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listConsultants(request, response);
                break;
            case "view":
                viewConsultant(request, response);
                break;
            case "add":
                showAddForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteConsultant(request, response);
                break;
            default:
                listConsultants(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "add":
                addConsultant(request, response);
                break;
            case "edit":
                updateConsultant(request, response);
                break;
            default:
                listConsultants(request, response);
                break;
        }
    }

    private void listConsultants(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Consultant> consultants = consultantService.getAllConsultants();
        request.setAttribute("consultants", consultants);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/consultants/list.jsp");
        dispatcher.forward(request, response);
    }

    private void viewConsultant(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Consultant consultant = consultantService.getConsultantById(id);

        if (consultant != null) {
            request.setAttribute("consultant", consultant);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/consultants/view.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/consultants");
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/consultants/add.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Consultant consultant = consultantService.getConsultantById(id);

        if (consultant != null) {
            request.setAttribute("consultant", consultant);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/consultants/edit.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/consultants");
        }
    }

    private void addConsultant(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data and create a new Consultant object
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String number = request.getParameter("number");
        String userType = request.getParameter("userType");
        String jobType = request.getParameter("jobType");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Consultant consultant = new Consultant();
        consultant.setName(name);
        consultant.setEmail(email);
        consultant.setNumber(number);
        consultant.setUserType(userType);
        consultant.setJobType(jobType);
        consultant.setUsername(username);
        consultant.setPassword(password);

        consultantService.addConsultant(consultant);

        response.sendRedirect(request.getContextPath() + "/consultants");
    }

    private void updateConsultant(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data and update an existing Consultant object
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String number = request.getParameter("number");
        String userType = request.getParameter("userType");
        String jobType = request.getParameter("jobType");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Consultant consultant = new Consultant();
        consultant.setId(Long.valueOf(id));
        consultant.setName(name);
        consultant.setEmail(email);
        consultant.setNumber(number);
        consultant.setUserType(userType);
        consultant.setJobType(jobType);
        consultant.setUsername(username);
        consultant.setPassword(password);

        consultantService.updateConsultant(consultant);

        response.sendRedirect(request.getContextPath() + "/consultants");
    }

    private void deleteConsultant(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        consultantService.deleteConsultant(id);

        response.sendRedirect(request.getContextPath() + "/consultants");
    }
}
