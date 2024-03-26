package com.medimate.MedicalRecordMicroservice.services;

import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import com.medimate.MedicalRecordMicroservice.models.Patient;
import com.medimate.MedicalRecordMicroservice.repositories.PatientRepository;
import com.medimate.MedicalRecordMicroservice.viewmodels.PatientVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repo;

    public PatientService(PatientRepository repo) {
        this.repo = repo;
    }

    public void addPatient(PatientVM patientRequest)
    {
        repo.save(
                new Patient(
                        patientRequest.getFirstName(),patientRequest.getLastName(),patientRequest.getBirthdate(),patientRequest.getGender(),patientRequest.getAddress(),patientRequest.getPhoneNumber()
                )
        );
    }
    public Patient getOnePatient(Integer id) {
        return repo.findById(id).orElse(null);
    }
    public List<Patient> getAllPatients()
    {
        return repo.findAll();
    }

    public void deleteOnePatient(Integer id)
    {
        repo.deleteById(id);
    }

}
