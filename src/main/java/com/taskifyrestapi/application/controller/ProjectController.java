package com.taskifyrestapi.application.controller;

import com.taskifyrestapi.application.dto.ProjectDTO;
import com.taskifyrestapi.application.model.Project;
import com.taskifyrestapi.application.service.ProjectService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teamleader")
public class ProjectController {
    @Autowired
    private ProjectService projectService ;

    @PostMapping("/projects/create/{teamLeadId}")
    @PreAuthorize("hasAuthority('TEAMLEADER')")
    @Transactional
    public ResponseEntity<Project> createProject(@RequestBody ProjectDTO projectDTO , @PathVariable int teamLeadId){
        Project project = projectService.createProject(projectDTO, teamLeadId);

        //todo: add the logic for adding members to project based on their ids
        System.out.println(projectDTO.getMembers());
        return ResponseEntity.ok(project) ;
    }

    @GetMapping("/projects")
    @PreAuthorize("hasAuthority('TEAMLEADER')")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects() ;
    }

    @DeleteMapping("/projects/{projectId}")
    @PreAuthorize("hasAuthority('TEAMLEADER')")
    @Transactional
    public ResponseEntity<?> deleteProject(@PathVariable int projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/projects/{projectId}")
    @Transactional
    public ResponseEntity<Project> updateProject(@PathVariable int projectId, @RequestBody ProjectDTO projectDTO) {
        Project updatedProject = projectService.updateProject(projectId, projectDTO);
        return ResponseEntity.ok(updatedProject);
    }

}
