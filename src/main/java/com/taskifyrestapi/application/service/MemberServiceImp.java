package com.taskifyrestapi.application.service;

import com.taskifyrestapi.application.model.Member;
import com.taskifyrestapi.application.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImp implements MemberService {
    
    private MemberRepository memberRepository ;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public MemberServiceImp(MemberRepository memberRepository){
        this.memberRepository = memberRepository ;
    }

    @Override
    public Member saveMember(Member member) {
        // Encode the password before saving
        String encodedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encodedPassword);
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
