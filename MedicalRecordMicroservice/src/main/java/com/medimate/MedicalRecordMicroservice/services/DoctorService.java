package com.medimate.MedicalRecordMicroservice.services;

import com.medimate.MedicalRecordMicroservice.models.Doctor;
import com.medimate.MedicalRecordMicroservice.models.Patient;
import com.medimate.MedicalRecordMicroservice.repositories.DoctorRepository;
import com.medimate.MedicalRecordMicroservice.viewmodels.DoctorVM;
import com.medimate.MedicalRecordMicroservice.viewmodels.MedicalRecordVM;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(DoctorVM doctorVM) {
        return doctorRepository.save(DoctorVM.toEntity(doctorVM));
    }

    public Doctor getDoctor(Integer id) {
        return doctorRepository.findById(id).orElseThrow(() -> new EntityExistsException("Could not find doctor with id " + id));
    }

    public Page<Doctor> getAllDoctors(int page, int size, String sortBy, String firstName, String lastName, String title) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        Page<Doctor> doctors;
        if (firstName != null && lastName != null && title != null) {
            doctors = doctorRepository.findByFirstNameContainingAndLastNameContainingAndTitleContaining(firstName, lastName, title, pageable);
        } else if (firstName != null && lastName != null) {
            doctors = doctorRepository.findByFirstNameContainingAndLastNameContaining(firstName, lastName, pageable);
        } else if (firstName != null && title != null) {
            doctors = doctorRepository.findByFirstNameContainingAndTitleContaining(firstName, title, pageable);
        } else if (lastName != null && title != null) {
            doctors = doctorRepository.findByLastNameContainingAndTitleContaining(lastName, title, pageable);
        } else if (firstName != null) {
            doctors = doctorRepository.findByFirstNameContaining(firstName, pageable);
        } else if (lastName != null) {
            doctors = doctorRepository.findByLastNameContaining(lastName, pageable);
        } else if (title != null) {
            doctors = doctorRepository.findByTitleContaining(title, pageable);
        } else {
            doctors = doctorRepository.findAll(pageable);
        }

        if (doctors.isEmpty()) {
            throw new EntityNotFoundException("There are no doctors matching the given filters");
        }
        return doctors;
    }

    public void deleteDoctor(Integer id) {
        doctorRepository.deleteById(id);
    }
}
