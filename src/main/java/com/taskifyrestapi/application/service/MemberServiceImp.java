package com.taskifyrestapi.application.service;

import com.taskifyrestapi.application.model.Member;
import com.taskifyrestapi.application.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImp implements MemberService {
    private MemberRepository memberRepository ;

    @Autowired
    public MemberServiceImp(MemberRepository memberRepository){
        this.memberRepository = memberRepository ;
    }


    @Override
    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }
}
