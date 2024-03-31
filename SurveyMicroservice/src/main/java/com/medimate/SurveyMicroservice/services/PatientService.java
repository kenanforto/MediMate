package com.medimate.SurveyMicroservice.services;

import com.medimate.SurveyMicroservice.models.Patient;
import com.medimate.SurveyMicroservice.repositories.PatientRepository;
import com.medimate.SurveyMicroservice.viewModels.PatientVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
