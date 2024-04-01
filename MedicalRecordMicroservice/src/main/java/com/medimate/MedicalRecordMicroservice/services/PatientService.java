package com.medimate.MedicalRecordMicroservice.services;

import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import com.medimate.MedicalRecordMicroservice.models.Patient;
import com.medimate.MedicalRecordMicroservice.repositories.PatientRepository;
import com.medimate.MedicalRecordMicroservice.viewmodels.PatientVM;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(PatientVM patientVM)
    {
        return patientRepository.save(PatientVM.toEntity(patientVM));
    }
    public Patient getPatient(Integer id) {
        return patientRepository.findById(id).orElseThrow(() -> new EntityExistsException("Could not find patient with id " + id));
    }
    public List<Patient> getAllPatients()
    {
        return patientRepository.findAll();
    }

    public void deleteOnePatient(Integer id)
    {
        patientRepository.deleteById(id);
    }

}
