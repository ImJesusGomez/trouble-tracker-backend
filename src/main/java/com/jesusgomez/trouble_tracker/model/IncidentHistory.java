package com.jesusgomez.trouble_tracker.model;

import com.jesusgomez.trouble_tracker.model.enums.IncidentStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Table(name = "incident_histories") @Entity
public class IncidentHistory {

    // Attributes
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "previous_status") @Enumerated(EnumType.STRING)
    private IncidentStatus previousStatus;

    @Column(name = "new_status") @Enumerated(EnumType.STRING)
    private IncidentStatus newStatus;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @CreationTimestamp() @Column(name = "created_at", updatable = false, nullable = false)
    private Instant createdAt;

    // Relationship
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "incident_id")
    private Incident incident;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "employee_id")
    private Employee employee;

    // Constructor
    public IncidentHistory() {
    }

    public IncidentHistory(UUID id, IncidentStatus previousStatus, IncidentStatus newStatus, String comment, Instant createdAt, Incident incident, Employee employee) {
        this.id = id;
        this.previousStatus = previousStatus;
        this.newStatus = newStatus;
        this.comment = comment;
        this.createdAt = createdAt;
        this.incident = incident;
        this.employee = employee;
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public IncidentStatus getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(IncidentStatus previousStatus) {
        this.previousStatus = previousStatus;
    }

    public IncidentStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(IncidentStatus newStatus) {
        this.newStatus = newStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
