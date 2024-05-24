package com.taskifyrestapi.application.controller;

import com.taskifyrestapi.application.model.Member;
import com.taskifyrestapi.application.model.Project;
import com.taskifyrestapi.application.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teamleader")
@CrossOrigin(origins = "http://localhost:3000")
public class MemberController {
    @Autowired
    private MemberService memberService ;

    @GetMapping("/members")
    @PreAuthorize("hasAuthority('TEAMLEADER')")
    public List<Member> getAllMembers(){
        return memberService.getAllMembers() ;
    }
}
