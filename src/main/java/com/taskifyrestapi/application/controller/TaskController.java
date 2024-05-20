package com.taskifyrestapi.application.controller;

import com.taskifyrestapi.application.model.Project;
import com.taskifyrestapi.application.model.Task;
import com.taskifyrestapi.application.service.ProjectService;
import com.taskifyrestapi.application.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    private TaskService taskService;
    private ProjectService projectService ;

    @Autowired
    public TaskController(ProjectService projectService , TaskService taskService){
        this.taskService = taskService ;
        this.projectService = projectService ;
    }



    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task task) {
        return taskService.getTaskById(id)
                .map(existingTask -> {
                    task.setId(id);
                    Task updatedTask = taskService.updateTask(task);
                    return ResponseEntity.ok(updatedTask);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id) {
        return taskService.getTaskById(id)
                .map(task -> {
                    taskService.deleteTask(id);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/project/{projectId}")
    public ResponseEntity<Task> addTaskToProject(@PathVariable int projectId, @RequestBody Task task) {
        return projectService.getProjectById(projectId)
                .map(project -> {
                    task.setProject(project);
                    Task savedTask = taskService.createTask(task);
                    return ResponseEntity.ok(savedTask);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{taskId}/members/{memberId}")
    public ResponseEntity<Task> addMemberToTask(@PathVariable int taskId, @PathVariable int memberId) {
        try {
            Task task = taskService.addMemberToTask(taskId, memberId);
            return ResponseEntity.ok(task);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
