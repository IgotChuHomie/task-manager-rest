package com.taskifyrestapi.application.dto;

import com.taskifyrestapi.application.enums.Label;
import com.taskifyrestapi.application.enums.Priority;
import com.taskifyrestapi.application.enums.Status;

import java.time.LocalDateTime;
import java.util.Date;

public class TaskDTO {
    private int id;
    private String description;
    private Date dueDate;
    private Priority priority;
    private Status status;
    private LocalDateTime createdAt;
    private String title;
    private Label label;
    private int projectId ;
    private int memberId ;

    public TaskDTO() {
    }

    public TaskDTO(String description, Date dueDate, Priority priority, Status status, LocalDateTime createdAt, String title, Label label , int projectId , int memberId) {
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
        this.createdAt = createdAt;
        this.title = title;
        this.label = label;
        this.memberId = memberId ;
        this.projectId = projectId ;
    }

    public TaskDTO(String description, Date dueDate, Priority priority, Status status, LocalDateTime createdAt, String title, Label label ) {
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
        this.createdAt = createdAt;
        this.title = title;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}
