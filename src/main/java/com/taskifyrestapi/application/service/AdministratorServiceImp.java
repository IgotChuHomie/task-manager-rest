package com.taskifyrestapi.application.service;

import com.taskifyrestapi.application.model.Administrator;
import com.taskifyrestapi.application.repository.AdministratorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImp implements AdministratorService{
    private AdministratorRepository administratorRepository ;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AdministratorServiceImp(AdministratorRepository administratorRepository){
        this.administratorRepository = administratorRepository ;
    }

    @Override
    public Administrator saveAdministrator(Administrator administrator) {
        String encodedPassword = passwordEncoder.encode(administrator.getPassword());
        administrator.setPassword(encodedPassword);
        return administratorRepository.save(administrator);
    }
}
