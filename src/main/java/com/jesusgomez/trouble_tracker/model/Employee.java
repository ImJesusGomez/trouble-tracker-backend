package com.jesusgomez.trouble_tracker.model;

import com.jesusgomez.trouble_tracker.model.enums.EmployeeRole;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "employees") @Entity
public class Employee {

    // Attributes
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 150, nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false) @Enumerated(EnumType.STRING)
    private EmployeeRole role;

    // Relationships
    @OneToMany(mappedBy = "reportedBy", cascade = CascadeType.ALL)
    private List<Incident> incidentsReported = new ArrayList<>();

    @OneToMany(mappedBy = "assignedTechnician", cascade = CascadeType.ALL)
    private List<Incident> incidentsAssigned = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<IncidentHistory> incidentHistories = new ArrayList<>();

    // Constructor
    public Employee() {
    }

    public Employee(UUID id, String firstName, String lastName, String email, String password, EmployeeRole role, List<Incident> incidentsReported, List<Incident> incidentsAssigned, List<IncidentHistory> incidentHistories) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.incidentsReported = incidentsReported;
        this.incidentsAssigned = incidentsAssigned;
        this.incidentHistories = incidentHistories;
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EmployeeRole getRole() {
        return role;
    }

    public void setRole(EmployeeRole role) {
        this.role = role;
    }

    public List<Incident> getIncidentsReported() {
        return incidentsReported;
    }

    public void setIncidentsReported(List<Incident> incidentsReported) {
        this.incidentsReported = incidentsReported;
    }

    public List<Incident> getIncidentsAssigned() {
        return incidentsAssigned;
    }

    public void setIncidentsAssigned(List<Incident> incidentsAssigned) {
        this.incidentsAssigned = incidentsAssigned;
    }

    public List<IncidentHistory> getIncidentHistories() {
        return incidentHistories;
    }

    public void setIncidentHistories(List<IncidentHistory> incidentHistories) {
        this.incidentHistories = incidentHistories;
    }
}
