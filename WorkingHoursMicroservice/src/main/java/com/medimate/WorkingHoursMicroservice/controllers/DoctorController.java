package com.medimate.WorkingHoursMicroservice.controllers;

import com.medimate.WorkingHoursMicroservice.models.Doctor;
import com.medimate.WorkingHoursMicroservice.services.DoctorService;
import com.medimate.WorkingHoursMicroservice.viewmodels.DoctorVM;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("")
    public Doctor addOne(@RequestBody @Valid DoctorVM doctorVM) {
        return doctorService.addOne(doctorVM);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        doctorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Doctor> getById(@PathVariable Integer id) {
        Doctor doctor = doctorService.getById(id);
        return (doctor != null) ? ResponseEntity.ok(doctor) : ResponseEntity.notFound().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Doctor>> getAll() {
        List<Doctor> doctors = doctorService.getAll();
        return (doctors != null) ? ResponseEntity.ok(doctors) : ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Doctor> updateAdmin(@PathVariable Integer id, @RequestBody DoctorVM doctorVM) {
        Doctor updatedDoctor = doctorService.updateById(id, doctorVM);
        return ResponseEntity.ok(updatedDoctor);
    }
}