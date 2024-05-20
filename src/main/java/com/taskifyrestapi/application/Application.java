package com.taskifyrestapi.application;

import com.taskifyrestapi.application.dto.ProjectDTO;
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
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner run(TaskService taskService ,  ProjectService projectService, TeamLeadService teamLeadService , MemberService memberService , AdministratorService administratorService) {
		return args -> {
			 TeamLeader user = new TeamLeader("teamleader0@gmail.com" , "teamlead","lastteamlead","some password");
			 teamLeadService.saveTeamLeader(user) ;

			TeamLeader user1 = new TeamLeader("teamleader1@gmail.com" , "teamlead","lastteamlead","some password");
			teamLeadService.saveTeamLeader(user1) ;

			 Member member = new Member("membereami@gmail.com" , "memberfirstname","memberlastName","somepassword") ;
			 memberService.saveMember(member) ;

			Member member1 = new Member("membereami@gmail.com" , "memberfirstname","memberlastName","somepassword") ;
			memberService.saveMember(member1) ;

			 //Administrator administrator = new Administrator("ismail" ,"ismail","chraibi","ismail chraibi") ;
			 //administratorService.saveAdministrator(administrator) ;

			List<Integer> projectIds = new ArrayList<>( );
			projectIds.add(1) ;
			projectIds.add(2) ;
			projectService.createProject(new ProjectDTO("projectName","some Fucking description" , projectIds, 1 ) , 1) ;

			LocalDate localDate = LocalDate.of(2024, 12, 25);
			Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			taskService.addTaskToProject(1 , new Task("task description " , date , Priority.High , Status.Backlog ,"the title " , Label.Bug )) ;
			taskService.addMemberToTask(1 , 3) ;
		};
	}
}
