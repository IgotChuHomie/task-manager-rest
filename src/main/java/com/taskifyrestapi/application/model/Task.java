package com.taskifyrestapi.application.model;

import com.taskifyrestapi.application.enums.Priority;
import com.taskifyrestapi.application.enums.Status;
import com.taskifyrestapi.application.enums.Type;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String description ;
    @Temporal(TemporalType.DATE)
    private Date dueDate ;
    @Enumerated(value = EnumType.STRING)
    private Priority priority ;
    @Enumerated(value = EnumType.STRING)
    private Status status ;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt ;
    private String title ;
    @Enumerated(value = EnumType.STRING)
    private Type type ;

    public Task(String description, Date dueDate, Priority priority, Status status, LocalDateTime createdAt, String title, Type type) {
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
        this.createdAt = createdAt;
        this.title = title;
        this.type = type;
    }

    public Task() {

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", title='" + title + '\'' +
                ", type=" + type +
                '}';
    }
}
