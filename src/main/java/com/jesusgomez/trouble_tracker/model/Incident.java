package com.jesusgomez.trouble_tracker.model;

import com.jesusgomez.trouble_tracker.model.enums.IncidentCategory;
import com.jesusgomez.trouble_tracker.model.enums.IncidentPriority;
import com.jesusgomez.trouble_tracker.model.enums.IncidentStatus;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "incidents") @Entity
public class Incident {

    // Attributes
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title", length = 150, nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "category", nullable = false) @Enumerated(EnumType.STRING)
    private IncidentCategory category;

    @Column(name = "location", length = 150, nullable = false)
    private String location;

    @Column(name = "affected_resource", length = 150, nullable = false)
    private String affectedResource;

    @Column(name = "started_at", nullable = false)
    private LocalDateTime startedAt;

    @Column(name = "priority", nullable = false) @Enumerated(EnumType.STRING)
    private  IncidentPriority priority;

    @Column(name = "additional_information", columnDefinition = "TEXT")
    private String additionalInformation;

    @Column(name = "status") @Enumerated(EnumType.STRING)
    private IncidentStatus status;

    // Relationships
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "reported_by")
    private Employee reportedBy;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "assignedTechnician")
    private Employee assignedTechnician;

    @OneToMany(mappedBy = "incident", cascade = CascadeType.ALL)
    private List<IncidentHistory> incidentHistories = new ArrayList<>();

    // Constructor
    public Incident() {
    }

    public Incident(UUID id, String title, String description, IncidentCategory category, String location, String affectedResource, LocalDateTime startedAt, IncidentPriority priority, String additionalInformation, IncidentStatus status, Employee reportedBy, Employee assignedTechnician, List<IncidentHistory> incidentHistories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.location = location;
        this.affectedResource = affectedResource;
        this.startedAt = startedAt;
        this.priority = priority;
        this.additionalInformation = additionalInformation;
        this.status = status;
        this.reportedBy = reportedBy;
        this.assignedTechnician = assignedTechnician;
        this.incidentHistories = incidentHistories;
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IncidentCategory getCategory() {
        return category;
    }

    public void setCategory(IncidentCategory category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAffectedResource() {
        return affectedResource;
    }

    public void setAffectedResource(String affectedResource) {
        this.affectedResource = affectedResource;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public IncidentPriority getPriority() {
        return priority;
    }

    public void setPriority(IncidentPriority priority) {
        this.priority = priority;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }

    public Employee getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(Employee reportedBy) {
        this.reportedBy = reportedBy;
    }

    public Employee getAssignedTechnician() {
        return assignedTechnician;
    }

    public void setAssignedTechnician(Employee assignedTechnician) {
        this.assignedTechnician = assignedTechnician;
    }

    public List<IncidentHistory> getIncidentHistories() {
        return incidentHistories;
    }

    public void setIncidentHistories(List<IncidentHistory> incidentHistories) {
        this.incidentHistories = incidentHistories;
    }
}
