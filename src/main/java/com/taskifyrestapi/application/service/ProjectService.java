package com.taskifyrestapi.application.service;

import com.taskifyrestapi.application.dto.ProjectDTO;
import com.taskifyrestapi.application.model.Project;

import java.util.List;

public interface ProjectService {
    Project saveProject(Project project) ;
    Project createProject(ProjectDTO projectDTO , int teamLeaderId) ;
    List<Project> getAllProjects() ;
    void deleteProject(int projectId) ;
    Project updateProject(int projectId , ProjectDTO projectDto) ;


}
