package com.taskifyrestapi.application.controller;

import com.taskifyrestapi.application.model.TeamLeader;
import com.taskifyrestapi.application.service.TeamLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teamleader")
@CrossOrigin(origins = "http://localhost:3000")
public class TeamLeaderController {
    @Autowired
    private TeamLeadService teamLeadService ;

    @GetMapping("/teamleaders")
    @PreAuthorize("hasAuthority('TEAMLEADER')")
    public List<TeamLeader> getAllTeamLeaders(){
        return teamLeadService.getAllTeamLeaders() ;
    }
}
