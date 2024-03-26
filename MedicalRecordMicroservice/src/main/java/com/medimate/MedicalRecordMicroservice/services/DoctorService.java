package com.medimate.MedicalRecordMicroservice.services;

import com.medimate.MedicalRecordMicroservice.models.Doctor;
import com.medimate.MedicalRecordMicroservice.models.Patient;
import com.medimate.MedicalRecordMicroservice.repositories.DoctorRepository;
import com.medimate.MedicalRecordMicroservice.viewmodels.DoctorVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository repo;

    public void addDoctor(DoctorVM doctorRequest)
    {
        repo.save(
                new Doctor(
                        doctorRequest.getFirstName(),doctorRequest.getLastName(),doctorRequest.getTitle()
                )
        );
    }
    public Doctor getOneDoctor(Integer id) {
        Doctor doctor=repo.findById(id).orElse(null);
        return doctor;
    }
    public List<Doctor> getAllDoctors()
    {
        return repo.findAll();
    }
    public void deleteOneDoctor(Integer id)
    {
        repo.deleteById(id);
    }
}
