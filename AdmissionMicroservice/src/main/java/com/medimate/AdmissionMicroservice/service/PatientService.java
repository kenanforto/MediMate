package com.medimate.AdmissionMicroservice.service;

import com.medimate.AdmissionMicroservice.models.Patient;
import com.medimate.AdmissionMicroservice.repositories.PatientRepository;
import com.medimate.AdmissionMicroservice.viewModels.PatientVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;

    public void addPatient(PatientVM patient)
    { //  LocalDate birthdate, Gender gender, String address, String phoneNumber
        repo.save(
                new Patient(
                        patient.getFirstName(),patient.getLastName(), patient.getBirthdate(), patient.getGender(), patient.getAddress(), patient.getPhoneNumber()
                )
        );
    }
    public Patient getOnePatient(Integer id)
    {
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
