package com.taskifyrestapi.application.service;

import com.taskifyrestapi.application.dto.ProjectDTO;
import com.taskifyrestapi.application.model.Administrator;
import com.taskifyrestapi.application.model.Project;
import com.taskifyrestapi.application.model.TeamLeader;
import com.taskifyrestapi.application.repository.AdministratorRepository;
import com.taskifyrestapi.application.repository.ProjectRepository;
import com.taskifyrestapi.application.repository.TeamLeaderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService{
    private ProjectRepository projectRepository ;
    private AdministratorRepository administratorRepository ;
    private TeamLeaderRepository teamLeaderRepository ;

    @Autowired
    public ProjectServiceImp(TeamLeaderRepository teamLeaderRepository ,  ProjectRepository projectRepository , AdministratorRepository administratorRepository){
        this.projectRepository = projectRepository ;
        this.teamLeaderRepository = teamLeaderRepository ;
        this.administratorRepository = administratorRepository ;
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project createProject(ProjectDTO projectDTO , int teamLeaderId){

        TeamLeader teamLeader = teamLeaderRepository.findById(teamLeaderId)
                .orElseThrow(()-> new RuntimeException("Administrator not found!")) ;
        Project project = new Project();
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setTeamLeader(teamLeader);
        return projectRepository.save(project) ;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll() ;
    }

    @Override
    @Transactional
    public void deleteProject(int projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Cannot find the project with the id of :" + projectId));
        projectRepository.delete(project);
    }

    @Override
    @Transactional
    public Project updateProject(int projectId, ProjectDTO projectDTO) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found with id " + projectId));
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        return projectRepository.save(project);
    }
}
