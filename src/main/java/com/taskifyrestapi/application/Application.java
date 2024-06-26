package com.taskifyrestapi.application;

import com.taskifyrestapi.application.config.PasswordConfig;
import com.taskifyrestapi.application.dto.ProjectDTO;
import com.taskifyrestapi.application.dto.TaskDTO;
import com.taskifyrestapi.application.enums.Label;
import com.taskifyrestapi.application.enums.Priority;
import com.taskifyrestapi.application.enums.Status;
import com.taskifyrestapi.application.model.Administrator;
import com.taskifyrestapi.application.model.Member;
import com.taskifyrestapi.application.model.Task;
import com.taskifyrestapi.application.model.TeamLeader;
import com.taskifyrestapi.application.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.taskifyrestapi.application.enums.Label.Documentation;
import static com.taskifyrestapi.application.enums.Priority.Low;
import static com.taskifyrestapi.application.enums.Status.Backlog;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner run(TaskService taskService ,  ProjectService projectService, TeamLeadService teamLeadService , MemberService memberService , AdministratorService administratorService) {
		return args -> {
			TeamLeader tl1 = new TeamLeader("amin@gmail.com" , "Amin","Doe","amin123");
			teamLeadService.saveTeamLeader(tl1) ;

			TeamLeader tl5 = new TeamLeader("sara@gmail.com" , "Sara","Lissaoui","sara123");
			teamLeadService.saveTeamLeader(tl5) ;

			Member member1 = new Member("ismail@gmail.com" , "Ismail","Chlih","ismail123") ;
			memberService.saveMember(member1) ;

			Member member2 = new Member("oussama@gmail.com" , "Oussama","Beth","oussama123") ;
			memberService.saveMember(member2) ;

			Member member3 = new Member("ghita@gmail.com" , "Ghita","Snow","ghita123") ;
			memberService.saveMember(member3) ;

			Member member4 = new Member("walid@gmail.com" , "Walid","Beth","walid123") ;
			memberService.saveMember(member4) ;

			Administrator administrator = new Administrator("admin@gmail.com" ,"admin","admin","admin123") ;
			administratorService.saveAdministrator(administrator) ;
			
			List<Integer> memberIds1 = Arrays.asList(3,4);
			List<Integer> memberIds2 = Arrays.asList(4, 5);
			projectService.createProject(new ProjectDTO("JakartaEE App","JakartaEE Projet Master GLCC" , memberIds1, 1) , 1) ;
			projectService.createProject(new ProjectDTO("Go App","Projet Go GLCC" , memberIds2, 2) , 2) ;

			taskService.createTask(new TaskDTO ("add new diagrams", new Date(), Low,Backlog,LocalDateTime.now(),"review pitch deck",Documentation), 2,4);

			LocalDate localDate = LocalDate.of(2024, 12, 25);
			Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		};
	}
}
