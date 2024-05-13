package com.taskifyrestapi.application;

import com.taskifyrestapi.application.model.Administrator;
import com.taskifyrestapi.application.model.Member;
import com.taskifyrestapi.application.model.TeamLeader;
import com.taskifyrestapi.application.service.AdministratorService;
import com.taskifyrestapi.application.service.MemberService;
import com.taskifyrestapi.application.service.TeamLeadService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner run(TeamLeadService teamLeadService , MemberService memberService , AdministratorService administratorService) {
		return args -> {
			TeamLeader user = new TeamLeader("aminel3zwa@gmail.com" , "teamlead","lastteamlead","some password");
			teamLeadService.saveTeamLeader(user) ;

			Member member = new Member("membereami@gmail.com" , "memberfirstname","memberlastName","somepassword") ;
			memberService.saveMember(member) ;

			Administrator administrator = new Administrator("ismail" ,"ismail","chraibi","ismail chraibi") ;
			administratorService.saveAdministrator(administrator) ;
		};
	}
}
