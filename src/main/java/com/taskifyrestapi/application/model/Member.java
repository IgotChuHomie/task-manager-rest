package com.taskifyrestapi.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("Member")
public class Member extends User {


    @JsonIgnore
    @ManyToMany(mappedBy = "members" )
    private List<Project> projects;

    @JsonIgnore
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Task> tasks;

    public Member() {
    }

    public Member(String email, String firstName, String lastName, String password) {
        super(email, firstName, lastName, password);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public String toString() {
        return "Member{" +
                "projects=" + projects +
                ", tasks=" + tasks +
                '}';
    }
}