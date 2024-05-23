package com.taskifyrestapi.application.service;

import com.taskifyrestapi.application.dto.TaskDTO;
import com.taskifyrestapi.application.model.Member;
import com.taskifyrestapi.application.model.Project;
import com.taskifyrestapi.application.model.Task;
import com.taskifyrestapi.application.repository.MemberRepository;
import com.taskifyrestapi.application.repository.ProjectRepository;
import com.taskifyrestapi.application.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp implements TaskService{

    private TaskRepository taskRepository ;
    private ProjectRepository projectRepository ;
    private MemberRepository memberRepository ;
    private ModelMapper modelMapper;

    @Autowired
    public TaskServiceImp(ModelMapper modelMapper ,  TaskRepository taskRepository , ProjectRepository projectRepository , MemberRepository memberRepository){
        this.projectRepository = projectRepository ;
        this.modelMapper = modelMapper ;
        this.memberRepository = memberRepository ;
        this.taskRepository = taskRepository ;
    }

    @Override
    @Transactional
    public Task createTask(TaskDTO taskDTO , int projectId, int memberId) {
        Task task = modelMapper.map(taskDTO, Task.class);
        Optional<Project> projectOptional = projectRepository.findById(projectId);
        if (!projectOptional.isPresent()) {
            throw new RuntimeException("Project not found");
        }
        task.setProject(projectOptional.get());

        Optional<Member> memberOptional = memberRepository.findById(memberId);
        if (!memberOptional.isPresent()) {
            throw new RuntimeException("Member not found");
        }
        task.setMember(memberOptional.get());

        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    @Transactional
    public Task updateTask(TaskDTO taskDTO) {
        Optional<Task> taskOptional = taskRepository.findById(taskDTO.getId());
        if (!taskOptional.isPresent()) {
            throw new RuntimeException("Task not found");
        }

        Task task = taskOptional.get();

        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        task.setPriority(taskDTO.getPriority());
        task.setStatus(taskDTO.getStatus());
        task.setTitle(taskDTO.getTitle());
        task.setLabel(taskDTO.getLabel());

        if (taskDTO.getProjectId() > 0 && task.getProject().getId() != taskDTO.getProjectId()) {
            Optional<Project> projectOptional = projectRepository.findById(taskDTO.getProjectId());
            if (!projectOptional.isPresent()) {
                throw new RuntimeException("Project not found");
            }
            task.setProject(projectOptional.get());
        }

        if (taskDTO.getMemberId() > 0 && task.getMember().getId() != taskDTO.getMemberId()) {
            Optional<Member> memberOptional = memberRepository.findById(taskDTO.getMemberId());
            if (!memberOptional.isPresent()) {
                throw new RuntimeException("Member not found");
            }
            task.setMember(memberOptional.get());
        }
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


}
