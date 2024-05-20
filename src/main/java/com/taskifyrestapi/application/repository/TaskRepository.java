package com.taskifyrestapi.application.repository;

import com.taskifyrestapi.application.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {
}
