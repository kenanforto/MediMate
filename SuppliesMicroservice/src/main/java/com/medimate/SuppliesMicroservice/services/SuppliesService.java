package com.medimate.SuppliesMicroservice.services;

import com.medimate.SuppliesMicroservice.models.Supplies;
import com.medimate.SuppliesMicroservice.repositories.AdminRepository;
import com.medimate.SuppliesMicroservice.repositories.SuppliesRepository;
import com.medimate.SuppliesMicroservice.viewmodels.SuppliesVM;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuppliesService {

    @Autowired
    SuppliesRepository repo;

    @Autowired
    AdminRepository adminRepo;

    public Supplies addOne(SuppliesVM suppliesVM){
        return repo.save(
                new Supplies(
                        suppliesVM.getMedicationName(),
                        suppliesVM.getAmount(),
                        adminRepo.findById(suppliesVM.getAdminId()).orElse(null))
        );
    }

    public void deleteById(Integer id){
        repo.deleteById(id);
    }

    public Supplies getById(Integer id){
        Optional<Supplies> suppliesOptional = repo.findById(id);
        return suppliesOptional.orElseThrow(() -> new EntityNotFoundException("Could not find supplies with id %d".formatted(id)));

    }
}
