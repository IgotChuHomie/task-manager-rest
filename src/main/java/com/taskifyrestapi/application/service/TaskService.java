package com.taskifyrestapi.application.service;

import com.taskifyrestapi.application.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Task updateTask(Task task);
    Optional<Task> getTaskById(int id ) ;
    void deleteTask(int taskId);
    Task addTaskToProject(int projectId, Task task) ;
    Task addMemberToTask(int taskId, int memberId);
}
