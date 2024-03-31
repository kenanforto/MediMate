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
    private DoctorRepository doctorRepository;

    public void addDoctor(DoctorVM doctorRequest)
    {
        doctorRepository.save(
                new Doctor(doctorRequest.getFirstName(),doctorRequest.getLastName(),doctorRequest.getTitle())
        );
    }
    public Doctor getDoctor(Integer id) {
        return doctorRepository.findById(id).orElse(null);
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
