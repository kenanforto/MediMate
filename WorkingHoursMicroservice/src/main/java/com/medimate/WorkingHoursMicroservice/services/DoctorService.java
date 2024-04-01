package com.medimate.WorkingHoursMicroservice.services;

import com.medimate.WorkingHoursMicroservice.models.Admin;
import com.medimate.WorkingHoursMicroservice.models.Doctor;
import com.medimate.WorkingHoursMicroservice.repositories.DoctorRepository;
import com.medimate.WorkingHoursMicroservice.viewmodels.DoctorVM;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository repo;


    public Doctor addOne(DoctorVM doctorVM) {
        return repo.save(
                new Doctor(
                        doctorVM.getFirstName(),
                        doctorVM.getLastName(),
                        doctorVM.getTitle()
                )
        );
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

    public List<Doctor> getAll(){
        Optional<List<Doctor>> doctors = Optional.of(repo.findAll());
        return doctors.orElseThrow(() -> new EntityNotFoundException("There are no doctors"));

    }

}
