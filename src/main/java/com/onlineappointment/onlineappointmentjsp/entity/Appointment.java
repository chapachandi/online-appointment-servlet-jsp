package com.onlineappointment.onlineappointmentjsp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private Registration jobSeeker;

    @ManyToOne
    @JoinColumn(name = "consultant_id")
    private Consultant consultant;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "time")
    private String time;

    @Column(name = "status")
    private String status;

    @Column(name = "is_approved")
    private boolean isApproved;

    public Appointment() {
        // Default constructor
    }

    public Appointment(Registration jobSeeker, Consultant consultant, LocalDateTime date, String time, String status, boolean isApproved) {
        this.jobSeeker = jobSeeker;
        this.consultant = consultant;
        this.date = date;
        this.time = time;
        this.status = status;
        this.isApproved = isApproved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Registration getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(Registration jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public void setConsultant(Consultant consultant) {
        this.consultant = consultant;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
