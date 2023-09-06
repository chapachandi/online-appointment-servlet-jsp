package com.onlineappointment.onlineappointmentjsp.service.serviceImpl;

import com.onlineappointment.onlineappointmentjsp.dao.JobDAO;
import com.onlineappointment.onlineappointmentjsp.dao.daoImpl.JobDAOImpl;
import com.onlineappointment.onlineappointmentjsp.entity.Job;
import com.onlineappointment.onlineappointmentjsp.service.JobService;

import java.util.List;

public class JobServiceImpl implements JobService {
    private final JobDAO jobDAO = new JobDAOImpl();

    @Override
    public List<Job> getAllJobs() {
        return jobDAO.getAllJobs();
    }

    @Override
    public Job getJobById(int id) {
        return jobDAO.getJobById(id);
    }

    @Override
    public void addJob(Job job) {
        jobDAO.addJob(job);
    }

    @Override
    public void updateJob(Job job) {
        jobDAO.updateJob(job);
    }

    @Override
    public void deleteJob(int id) {
        jobDAO.deleteJob(id);
    }

    @Override
    public List<Job> searchJobsByCountryAndType(String country, String jobType) {
        return jobDAO.searchJobsByCountryAndType(country, jobType);
    }
}
