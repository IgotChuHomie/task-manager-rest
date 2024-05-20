package com.taskifyrestapi.application.service;

import com.taskifyrestapi.application.model.Member;
import com.taskifyrestapi.application.model.Project;
import com.taskifyrestapi.application.model.Task;
import com.taskifyrestapi.application.repository.MemberRepository;
import com.taskifyrestapi.application.repository.ProjectRepository;
import com.taskifyrestapi.application.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp implements TaskService{

    private TaskRepository taskRepository ;
    private ProjectRepository projectRepository ;
    private MemberRepository memberRepository ;

    @Autowired
    public TaskServiceImp(TaskRepository taskRepository , ProjectRepository projectRepository , MemberRepository memberRepository){
        this.projectRepository = projectRepository ;
        this.memberRepository = memberRepository ;
        this.taskRepository = taskRepository ;
    }

    @Override
    @Transactional
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    @Transactional
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> getTaskById(int id) {
        return taskRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteTask(int taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    @Transactional
    public Task addTaskToProject(int projectId, Task task) {
        Optional<Project> project = projectRepository.findById(projectId);
        if (project.isPresent()) {
            task.setProject(project.get());
            return taskRepository.save(task);
        } else {
            throw new RuntimeException("Project not found with id: " + projectId);
        }
    }

    @Override
    @Transactional
    public Task addMemberToTask(int taskId, int memberId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        Optional<Member> memberOptional = memberRepository.findById(memberId);

        if (taskOptional.isPresent() && memberOptional.isPresent()) {
            Task task = taskOptional.get();
            Member member = memberOptional.get();

            task.setMember(member);
            return taskRepository.save(task);
        } else {
            throw new RuntimeException("Task or Member not found");
        }
    }
}
