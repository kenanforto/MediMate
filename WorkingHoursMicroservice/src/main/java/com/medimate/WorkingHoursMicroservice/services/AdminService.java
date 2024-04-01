package com.medimate.WorkingHoursMicroservice.services;

import com.medimate.WorkingHoursMicroservice.models.Admin;
import com.medimate.WorkingHoursMicroservice.repositories.AdminRepository;
import com.medimate.WorkingHoursMicroservice.viewmodels.AdminVM;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    AdminRepository repo;

    public Admin addOne(AdminVM adminVM) {
        return repo.save(
                new Admin(
                        adminVM.getFirstName(),
                        adminVM.getLastName()
                )
        );
    }

    public void deleteById(Integer id) {
        Optional<Admin> adminOptional = repo.findById(id);
        if (adminOptional.isPresent()) {
            repo.deleteById(id);
        } else {
            throw new EntityNotFoundException("Could not find admin with id " + id);
        }
    }


    public Admin getById(Integer id) {
        Optional<Admin> adminOptional = repo.findById(id);
        return adminOptional.orElseThrow(() -> new EntityNotFoundException("Could not find admin with id %d".formatted(id)));
    }

    public List<Admin> getAll() {
        Optional<List<Admin>> admins = Optional.of(repo.findAll());
        return admins.orElseThrow(() -> new EntityNotFoundException("There are no admins"));
    }
}
