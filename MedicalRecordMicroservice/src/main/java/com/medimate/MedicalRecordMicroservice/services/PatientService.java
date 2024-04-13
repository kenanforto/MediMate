package com.medimate.MedicalRecordMicroservice.services;

import com.medimate.MedicalRecordMicroservice.models.Doctor;
import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import com.medimate.MedicalRecordMicroservice.models.Patient;
import com.medimate.MedicalRecordMicroservice.repositories.PatientRepository;
import com.medimate.MedicalRecordMicroservice.viewmodels.PatientVM;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(PatientVM patientVM) {
        return patientRepository.save(PatientVM.toEntity(patientVM));
    }

    public Patient getPatient(Integer id) {
        return patientRepository.findById(id).orElseThrow(() -> new EntityExistsException("Could not find patient with id " + id));
    }

    public Page<Patient> getAllPatients(int page, int size, String sortBy, String firstName, String lastName) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        Page<Patient> patients;
        if (firstName != null && lastName != null) {
            patients = patientRepository.findByFirstNameContainingAndLastNameContaining(firstName, lastName, pageable);
        } else if (firstName != null) {
            patients = patientRepository.findByFirstNameContaining(firstName, pageable);
        } else if (lastName != null) {
            patients = patientRepository.findByLastNameContaining(lastName, pageable);
        } else {
            patients = patientRepository.findAll(pageable);
        }

        if (patients.isEmpty()) {
            throw new EntityNotFoundException("There are no patients matching the given filters");
        }
        return patients;
    }

    public void deleteOnePatient(Integer id) {
        patientRepository.deleteById(id);
    }

}
