package com.medimate.WorkingHoursMicroservice.services;

import com.medimate.WorkingHoursMicroservice.models.Admin;
import com.medimate.WorkingHoursMicroservice.models.Doctor;
import com.medimate.WorkingHoursMicroservice.models.WorkingHours;
import com.medimate.WorkingHoursMicroservice.repositories.DoctorRepository;
import com.medimate.WorkingHoursMicroservice.viewmodels.DoctorVM;
import com.medimate.WorkingHoursMicroservice.viewmodels.WorkingHoursVM;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository repo;


    public Doctor addOne(DoctorVM doctorVM)
    {
        return repo.save(DoctorVM.toEntity(doctorVM));
    }
    public void deleteById(Integer id) {
        Optional<Doctor> doctorOptional = repo.findById(id);
        if (doctorOptional.isPresent()) {
            repo.deleteById(id);
        } else {
            throw new EntityNotFoundException("Could not find doctor with id " + id);
        }
    }

    public Doctor getById(Integer id) {
        Optional<Doctor> doctorOptional = repo.findById(id);
        return doctorOptional.orElseThrow(() -> new EntityNotFoundException("Could not find doctor with id %d".formatted(id)));
    }

    public Page<Doctor> getAll(int page, int size, String sortBy, String firstName, String lastName, String title) {
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


    public Doctor updateById(Integer id, DoctorVM doctorVM) {
        Doctor existingDoctor = getById(id);

        existingDoctor.setFirstName(doctorVM.getFirstName() != null ? doctorVM.getFirstName() : existingDoctor.getFirstName());
        existingDoctor.setLastName(doctorVM.getLastName() != null ? doctorVM.getLastName() : existingDoctor.getLastName());
        existingDoctor.setTitle(doctorVM.getTitle() != null ? doctorVM.getTitle() : existingDoctor.getTitle());

        return repo.save(existingDoctor);
    }

}
