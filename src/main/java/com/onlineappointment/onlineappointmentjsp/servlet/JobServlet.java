package com.onlineappointment.onlineappointmentjsp.servlet;


import com.onlineappointment.onlineappointmentjsp.entity.Job;
import com.onlineappointment.onlineappointmentjsp.service.JobService;
import com.onlineappointment.onlineappointmentjsp.service.serviceImpl.JobServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/jobs")
public class JobsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final JobService jobService = new JobServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listJobs(request, response);
                break;
            case "view":
                viewJob(request, response);
                break;
            case "add":
                showAddForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteJob(request, response);
                break;
            case "search":
                searchJobs(request, response);
                break;
            default:
                listJobs(request, response);
                break;
        }
    }

    private void listJobs(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Job> jobs = jobService.getAllJobs();
        request.setAttribute("jobs", jobs);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jobs/list.jsp");
        dispatcher.forward(request, response);
    }

    private void viewJob(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int jobId = Integer.parseInt(request.getParameter("id"));
        Job job = jobService.getJobById(jobId);
        request.setAttribute("job", job);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jobs/view.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jobs/add.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int jobId = Integer.parseInt(request.getParameter("id"));
        Job job = jobService.getJobById(jobId);
        request.setAttribute("job", job);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jobs/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteJob(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int jobId = Integer.parseInt(request.getParameter("id"));
        jobService.deleteJob(jobId);

        response.sendRedirect(request.getContextPath() + "/jobs");
    }

    private void searchJobs(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String country = request.getParameter("country");
        String jobType = request.getParameter("jobType");

        if (country != null && jobType != null) {
            List<Job> jobs = jobService.searchJobsByCountryAndType(country, jobType);
            request.setAttribute("jobs", jobs);
            request.setAttribute("searchCountry", country);
            request.setAttribute("searchJobType", jobType);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/jobs/search.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "add":
                addJob(request, response);
                break;
            case "edit":
                updateJob(request, response);
                break;
            default:
                listJobs(request, response);
                break;
        }
    }

    private void addJob(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String country = request.getParameter("country");
        String jobTitle = request.getParameter("jobTitle");
        String jobType = request.getParameter("jobType");
        String location = request.getParameter("location");
        String description = request.getParameter("description");

        Job job = new Job();
        job.setCountry(country);
        job.setJobTitle(jobTitle);
        job.setJobType(jobType);
        job.setLocation(location);
        job.setDescription(description);

        jobService.addJob(job);

        response.sendRedirect(request.getContextPath() + "/jobs");
    }

    private void updateJob(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int jobId = Integer.parseInt(request.getParameter("id"));
        String country = request.getParameter("country");
        String jobTitle = request.getParameter("jobTitle");
        String jobType = request.getParameter("jobType");
        String location = request.getParameter("location");
        String description = request.getParameter("description");

        Job job = new Job();
        job.setId(Long.valueOf(jobId));
        job.setCountry(country);
        job.setJobTitle(jobTitle);
        job.setJobType(jobType);
        job.setLocation(location);
        job.setDescription(description);

        jobService.updateJob(job);

        response.sendRedirect(request.getContextPath() + "/jobs");
    }
}

