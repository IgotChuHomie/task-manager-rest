package com.taskifyrestapi.application.service;

import com.taskifyrestapi.application.dto.ProjectDTO;
import com.taskifyrestapi.application.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Project saveProject(Project project) ;
    Optional<Project> getProjectById(int projectId);
    Project createProject(ProjectDTO projectDTO , int teamLeaderId) ;
    List<Project> getAllProjects() ;
    void deleteProject(int projectId) ;
    Project updateProject(int projectId , ProjectDTO projectDto) ;


}
