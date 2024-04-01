package com.medimate.AdmissionMicroservice.service;

import com.medimate.AdmissionMicroservice.models.Patient;
import com.medimate.AdmissionMicroservice.repositories.PatientRepository;
import com.medimate.AdmissionMicroservice.viewModels.PatientVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;


import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public void addPatient(PatientVM patient)
    { //  LocalDate birthdate, Gender gender, String address, String phoneNumber
        repo.save(PatientVM.toEntity(patient));
    }
    public Patient getPatient(Integer id)
    {
        return repo.findById(id).orElseThrow(()-> new EntityNotFoundException("Could not find patient with id: "+id));
    }
    public List<Patient> getAllPatients()
    {
        return repo.findAll();
    }
    public void deletePatient(Integer id)
    {
        repo.deleteById(id);
    }
}
