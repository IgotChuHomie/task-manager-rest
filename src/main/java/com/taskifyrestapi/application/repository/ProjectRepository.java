package com.taskifyrestapi.application.repository;

import com.taskifyrestapi.application.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}