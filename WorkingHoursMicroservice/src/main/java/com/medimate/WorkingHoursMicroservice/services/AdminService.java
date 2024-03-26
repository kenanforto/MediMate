package com.medimate.WorkingHoursMicroservice.services;

import com.medimate.WorkingHoursMicroservice.models.Admin;
import com.medimate.WorkingHoursMicroservice.repositories.AdminRepository;
import com.medimate.WorkingHoursMicroservice.viewmodels.AdminVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    AdminRepository repo;

    public void addOne(AdminVM adminVM){
        repo.save(
                new Admin(
                        adminVM.getFirstName(),
                        adminVM.getLastName()
                )
        );
    }

    public void deleteById(Integer id){
        repo.deleteById(id);

    }

    public Admin getById(Integer id){
        Optional<Admin> adminOptional = repo.findById(id);
        return adminOptional.orElse(null);
    }
}
