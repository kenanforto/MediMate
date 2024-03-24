package com.medimate.MedicalRecordMicroservice.services;

import com.medimate.MedicalRecordMicroservice.models.Doctor;
import com.medimate.MedicalRecordMicroservice.repositories.DoctorRepository;
import com.medimate.MedicalRecordMicroservice.viewmodels.DoctorVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository repo;

    public void saveDoctor(DoctorVM doctorRequest)
    {
        repo.save(
                new Doctor(
                        doctorRequest.getFirstName(),doctorRequest.getLastName(),doctorRequest.getTitle()
                )
        );
    }
}
