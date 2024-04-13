package com.medimate.SuppliesMicroservice.services;

import com.medimate.SuppliesMicroservice.models.Admin;
import com.medimate.SuppliesMicroservice.models.Supplies;
import com.medimate.SuppliesMicroservice.repositories.AdminRepository;
import com.medimate.SuppliesMicroservice.repositories.SuppliesRepository;
import com.medimate.SuppliesMicroservice.viewmodels.SuppliesVM;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SuppliesService {

    @Autowired
    SuppliesRepository repo;

    @Autowired
    AdminRepository adminRepo;

    public Supplies addOne(SuppliesVM suppliesVM) {
        return repo.save(SuppliesVM.toEntity(suppliesVM));
    }

    public Page<Supplies> getAll(int page, int size, String sortBy, String medicationName) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Supplies> supplies;
        if (medicationName != null) {
            supplies = repo.findByMedicationNameContaining(medicationName);
        } else {
            supplies = repo.findAll(pageable);
        }
        if (supplies.isEmpty()) {
            throw new EntityNotFoundException("There are no supplies");
        }
        return supplies;
    }


    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    public Supplies getById(Integer id) {
        Optional<Supplies> suppliesOptional = repo.findById(id);
        return suppliesOptional.orElseThrow(() -> new EntityNotFoundException("Could not find supplies with id %d".formatted(id)));
    }

    public Supplies updateById(Integer id, SuppliesVM suppliesVM) {
        Supplies existingSupplies = getById(id);

        existingSupplies.setAmount(suppliesVM.getAmount() != null ? suppliesVM.getAmount() : existingSupplies.getAmount());
        existingSupplies.setMedicationName(suppliesVM.getMedicationName() != null ? suppliesVM.getMedicationName() : existingSupplies.getMedicationName());

        return repo.save(existingSupplies);
    }
}
