package com.taskifyrestapi.application.service;

import com.taskifyrestapi.application.model.TeamLeader;

import java.util.List;

public interface TeamLeadService {
    TeamLeader saveTeamLeader(TeamLeader teamLeader) ;
    List<TeamLeader> getAllTeamLeaders() ;
}
