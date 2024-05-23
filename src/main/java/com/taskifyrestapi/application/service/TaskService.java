package com.taskifyrestapi.application.service;

import com.taskifyrestapi.application.dto.TaskDTO;
import com.taskifyrestapi.application.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(TaskDTO taskDTO , int projectId, int memberId);
    List<Task> getAllTasks();
    Task updateTask(TaskDTO taskDTO);
    Optional<Task> getTaskById(int id ) ;
    void deleteTask(int taskId);
}
