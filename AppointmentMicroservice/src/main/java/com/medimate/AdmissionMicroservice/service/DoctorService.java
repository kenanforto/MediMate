package com.medimate.AdmissionMicroservice.service;

import com.medimate.AdmissionMicroservice.models.Doctor;
import com.medimate.AdmissionMicroservice.repositories.DoctorRepository;
import com.medimate.AdmissionMicroservice.viewModels.DoctorVM;
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
    private DoctorRepository repo;

    public void addDoctor(DoctorVM doctor) {
        repo.save(DoctorVM.toEntity(doctor));
    }

    public Doctor getDoctor(Integer id) {
        //Doctor doctor=repo.findById(id).orElse(null);
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find doctor with id: " + id));
    }


    public Page<Doctor> getAllDoctors(int page, int size, String sortBy, String firstName, String lastName, String title) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        Page<Doctor> doctors;
        if (firstName != null && lastName != null && title != null) {
            doctors = repo.findByFirstNameContainingAndLastNameContainingAndTitleContaining(firstName, lastName, title, pageable);
        } else if (firstName != null && lastName != null) {
            doctors = repo.findByFirstNameContainingAndLastNameContaining(firstName, lastName, pageable);
        } else if (firstName != null && title != null) {
            doctors = repo.findByFirstNameContainingAndTitleContaining(firstName, title, pageable);
        } else if (lastName != null && title != null) {
            doctors = repo.findByLastNameContainingAndTitleContaining(lastName, title, pageable);
        } else if (firstName != null) {
            doctors = repo.findByFirstNameContaining(firstName, pageable);
        } else if (lastName != null) {
            doctors = repo.findByLastNameContaining(lastName, pageable);
        } else if (title != null) {
            doctors = repo.findByTitleContaining(title, pageable);
        } else {
            doctors = repo.findAll(pageable);
        }

        if (doctors.isEmpty()) {
            throw new EntityNotFoundException("There are no doctors matching the given filters");
        }
        return doctors;
    }

    public void deleteDoctor(Integer id) {
        repo.deleteById(id);
    }
}
