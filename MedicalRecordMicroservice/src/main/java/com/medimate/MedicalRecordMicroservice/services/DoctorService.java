package com.medimate.MedicalRecordMicroservice.services;

import com.medimate.MedicalRecordMicroservice.models.Doctor;
import com.medimate.MedicalRecordMicroservice.models.Patient;
import com.medimate.MedicalRecordMicroservice.repositories.DoctorRepository;
import com.medimate.MedicalRecordMicroservice.viewmodels.DoctorVM;
import com.medimate.MedicalRecordMicroservice.viewmodels.MedicalRecordVM;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(DoctorVM doctorVM)
    {
        return doctorRepository.save(DoctorVM.toEntity(doctorVM));
    }
    public Doctor getDoctor(Integer id) {
        return doctorRepository.findById(id).orElseThrow(() -> new EntityExistsException("Could not find doctor with id " + id));
    }
    public List<Doctor> getAllDoctors()
    {
        return doctorRepository.findAll();
    }
    public void deleteDoctor(Integer id)
    {
        doctorRepository.deleteById(id);
    }
}
