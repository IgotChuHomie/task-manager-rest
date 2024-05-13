package com.taskifyrestapi.application.repository;

import com.taskifyrestapi.application.model.TeamLeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamLeaderRepository extends JpaRepository<TeamLeader, Integer> {
}