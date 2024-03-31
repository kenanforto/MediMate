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
    private PatientRepository patientRepository;

    public PatientService(PatientRepository repo) {
        this.patientRepository = repo;
    }

    public void addPatient(PatientVM patientRequest)
    {
        patientRepository.save(
                new Patient(patientRequest.getFirstName(),patientRequest.getLastName(),patientRequest.getBirthdate(),patientRequest.getGender(),patientRequest.getAddress(),patientRequest.getPhoneNumber())
        );
    }
    public Patient getOnePatient(Integer id) {
        return patientRepository.findById(id).orElse(null);
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
