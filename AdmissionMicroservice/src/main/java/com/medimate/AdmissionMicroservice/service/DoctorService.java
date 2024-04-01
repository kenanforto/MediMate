package com.medimate.AdmissionMicroservice.service;

import com.medimate.AdmissionMicroservice.models.Doctor;
import com.medimate.AdmissionMicroservice.repositories.DoctorRepository;
import com.medimate.AdmissionMicroservice.viewModels.DoctorVM;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository repo;

    public void addDoctor(DoctorVM doctor)
    {
        repo.save(DoctorVM.toEntity(doctor));
    }
    public Doctor getDoctor(Integer id) {
        //Doctor doctor=repo.findById(id).orElse(null);
        return repo.findById(id).orElseThrow(()->new EntityNotFoundException("Could not find doctor with id: "+id));
    }
    public List<Doctor> getAllDoctors()
    {
        return repo.findAll();
    }
    public void deleteDoctor(Integer id)
    {
        repo.deleteById(id);
    }
}
