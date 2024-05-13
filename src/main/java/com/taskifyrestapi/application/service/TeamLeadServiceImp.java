package com.taskifyrestapi.application.service;

import com.taskifyrestapi.application.model.TeamLeader;
import com.taskifyrestapi.application.repository.TeamLeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamLeadServiceImp implements TeamLeadService{
    private TeamLeaderRepository teamLeaderRepository ;

    @Autowired
    public TeamLeadServiceImp(TeamLeaderRepository teamLeaderRepository){
        this.teamLeaderRepository = teamLeaderRepository ;
    }

    @Override
    public TeamLeader saveTeamLeader(TeamLeader teamLeader) {
        return teamLeaderRepository.save(teamLeader);
    }
}
