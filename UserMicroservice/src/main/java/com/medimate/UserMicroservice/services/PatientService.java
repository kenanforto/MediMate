package com.medimate.UserMicroservice.services;

import com.medimate.UserMicroservice.models.Doctor;
import com.medimate.UserMicroservice.models.Patient;
import com.medimate.UserMicroservice.repositories.PatientRepository;
import com.medimate.UserMicroservice.viewmodels.PatientVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public void addPatient(PatientVM patient) { //  LocalDate birthdate, Gender gender, String address, String phoneNumber
        repo.save(PatientVM.toEntity(patient));
    }

    public Patient getPatient(Integer id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find patient with id: " + id));
    }

    public Page<Patient> getAllPatients(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        Page<Patient> patients;
        patients = repo.findAll(pageable);

        if (patients.isEmpty()) {
            throw new EntityNotFoundException("There are no patients matching the given filters");
        }
        return patients;
    }

    @Transactional
    public void deletePatient(Integer userId) {
        repo.deleteByUserId(userId);
    }
}
