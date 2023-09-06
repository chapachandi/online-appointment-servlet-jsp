package com.onlineappointment.onlineappointmentjsp.service;

import com.onlineappointment.onlineappointmentjsp.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();
    Job getJobById(int id);
    void addJob(Job job);
    void updateJob(Job job);
    void deleteJob(int id);
    List<Job> searchJobsByCountryAndType(String country, String jobType);
}
