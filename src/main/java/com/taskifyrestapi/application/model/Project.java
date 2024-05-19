package com.taskifyrestapi.application.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String description ;
    private String name ;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt ;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "administrator_id")
    private Administrator administrator;


    @ManyToOne
    @JoinColumn(name = "team_lead")
    private TeamLeader teamLeader;


    @JsonIgnore
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks;

    @JsonIgnore
    @ManyToMany()
    @JoinTable(
            name = "project_member",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<Member> members;

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }


    public Project(String description, String name, LocalDateTime createdAt) {
        this.description = description;
        this.name = name;
        this.createdAt = createdAt;
    }

    public Project(){

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public TeamLeader getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(TeamLeader teamLeader) {
        this.teamLeader = teamLeader;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", administrator=" + administrator +
                ", teamLeader=" + teamLeader +
                ", tasks=" + tasks +
                ", members=" + members +
                '}';
    }
}
