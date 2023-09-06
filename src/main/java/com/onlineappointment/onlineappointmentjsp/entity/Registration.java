package com.onlineappointment.onlineappointmentjsp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "users") // Specify the table name
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specify the primary key generation strategy
    @Column(name = "user_id") // Specify the column name in the table
    private Long id; // Assuming you want an auto-generated ID

    @Column(name = "full_name") // Specify the column name in the table
    private String name;

    @Column(name = "user_email") // Specify the column name in the table
    private String email;

    @Column(name = "number") // Specify the column name in the table
    private String number;

    @Column(name = "user_type") // Specify the column name in the table
    private String userType;

    @Column(name = "user_username") // Specify the column name in the table
    private String username;

    @Column(name = "user_password") // Specify the column name in the table
    private String password;

    // Constructors, getters, and setters

    public Registration() {
        // Default constructor
    }

    public Registration(String name, String email, String number, String userType, String username, String password) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.userType = userType;
        this.username = username;
        this.password = password;
    }

    // Getter and Setter methods for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
