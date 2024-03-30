package com.medimate.AdmissionMicroservice.service;

import com.medimate.AdmissionMicroservice.models.Doctor;
import com.medimate.AdmissionMicroservice.repositories.DoctorRepository;
import com.medimate.AdmissionMicroservice.viewModels.DoctorVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository repo;

    public void addDoctor(DoctorVM doctor)
    {
        repo.save(
                new Doctor(
                        doctor.getFirstName(),
                        doctor.getLastName(),
                        doctor.getTitle()
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
