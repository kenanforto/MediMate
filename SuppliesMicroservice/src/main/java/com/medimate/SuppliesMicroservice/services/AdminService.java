package com.medimate.SuppliesMicroservice.services;

import com.medimate.SuppliesMicroservice.models.Admin;
import com.medimate.SuppliesMicroservice.repositories.AdminRepository;
import com.medimate.SuppliesMicroservice.viewmodels.AdminVM;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        repo.deleteById(id);

    }

    public Admin getById(Integer id) {
        Optional<Admin> adminOptional = repo.findById(id);
        return adminOptional.orElseThrow(() -> new EntityNotFoundException("Could not find admin with id %d".formatted(id)));
    }
}
