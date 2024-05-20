package com.taskifyrestapi.application.service;

import com.taskifyrestapi.application.model.Member;

import java.util.List;

public interface MemberService {
    Member saveMember(Member member) ;
    List<Member> getAllMembers() ;
}
