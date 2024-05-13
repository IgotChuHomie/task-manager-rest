package com.taskifyrestapi.application.service;

import com.taskifyrestapi.application.model.Administrator;
import com.taskifyrestapi.application.repository.AdministratorRepository;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImp implements AdministratorService{
    private AdministratorRepository administratorRepository ;

    public AdministratorServiceImp(AdministratorRepository administratorRepository){
        this.administratorRepository = administratorRepository ;
    }

    @Override
    public Administrator saveAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }
}
