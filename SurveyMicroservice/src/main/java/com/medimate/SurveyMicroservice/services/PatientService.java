package com.medimate.SurveyMicroservice.services;

import com.medimate.SurveyMicroservice.models.Patient;
import com.medimate.SurveyMicroservice.repositories.PatientRepository;
import com.medimate.SurveyMicroservice.viewModels.PatientVM;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repo;

    public PatientService(PatientRepository repo) {
        this.repo = repo;
    }

    public void addPatient(PatientVM patientRequest) {
        repo.save(
                new Patient(
                        patientRequest.getFirstName(), patientRequest.getLastName(), patientRequest.getBirthdate(), patientRequest.getGender(), patientRequest.getAddress(), patientRequest.getPhoneNumber()
                )
        );
    }

    public Patient getOnePatient(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Page<Patient> getAllPatients(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Patient> patients = repo.findAll(pageable);
        if (patients.isEmpty()) {
            throw new EntityNotFoundException("There are no patients");
        }
        return patients;
    }


    public void deleteOnePatient(Integer id) {
        repo.deleteById(id);
    }
}
