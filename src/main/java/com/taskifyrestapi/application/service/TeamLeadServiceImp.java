package com.taskifyrestapi.application.service;

import com.taskifyrestapi.application.model.Project;
import com.taskifyrestapi.application.model.TeamLeader;
import com.taskifyrestapi.application.repository.ProjectRepository;
import com.taskifyrestapi.application.repository.TeamLeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamLeadServiceImp implements TeamLeadService{
    private TeamLeaderRepository teamLeaderRepository ;
    private ProjectRepository projectRepository ;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public TeamLeadServiceImp(TeamLeaderRepository teamLeaderRepository , ProjectRepository projectRepository){
        this.teamLeaderRepository = teamLeaderRepository ;
        this.projectRepository = projectRepository ;
    }

    @Override
    public TeamLeader saveTeamLeader(TeamLeader teamLeader) {
        String encodedPassword = passwordEncoder.encode(teamLeader.getPassword());
        teamLeader.setPassword(encodedPassword);
        return teamLeaderRepository.save(teamLeader);
    }

    @Override
    public List<TeamLeader> getAllTeamLeaders() {
        return teamLeaderRepository.findAll();
    }


}
