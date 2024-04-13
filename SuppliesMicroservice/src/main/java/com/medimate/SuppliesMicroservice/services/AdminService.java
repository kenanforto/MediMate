package com.medimate.SuppliesMicroservice.services;

import com.medimate.SuppliesMicroservice.models.Admin;
import com.medimate.SuppliesMicroservice.repositories.AdminRepository;
import com.medimate.SuppliesMicroservice.viewmodels.AdminVM;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    AdminRepository repo;

    public Admin addOne(AdminVM adminVM) {
        return repo.save(AdminVM.toEntity(adminVM));
    }


    public void deleteById(Integer id) {
        repo.deleteById(id);

    }

    public Page<Admin> getAll(int page, int size, String sortBy, String firstName, String lastName) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        Page<Admin> admins;
        if (firstName != null && lastName != null) {
            admins = repo.findByFirstNameContainingAndLastNameContaining(firstName, lastName, pageable);
        } else if (firstName != null) {
            admins = repo.findByFirstNameContaining(firstName, pageable);
        } else if (lastName != null) {
            admins = repo.findByLastNameContaining(lastName, pageable);
        } else {
            admins = repo.findAll(pageable);
        }

        if (admins.isEmpty()) {
            throw new EntityNotFoundException("There are no admins matching the given filters");
        }
        return admins;
    }

    public Admin getById(Integer id) {
        Optional<Admin> adminOptional = repo.findById(id);
        return adminOptional.orElseThrow(() -> new EntityNotFoundException("Could not find admin with id %d".formatted(id)));
    }

    public Admin updateById(Integer id, AdminVM adminVM) {
        Admin existingAdmin = getById(id);

        existingAdmin.setFirstName(adminVM.getFirstName() != null ? adminVM.getFirstName() : existingAdmin.getFirstName());
        existingAdmin.setLastName(adminVM.getLastName() != null ? adminVM.getLastName() : existingAdmin.getLastName());

        return repo.save(existingAdmin);
    }

}
