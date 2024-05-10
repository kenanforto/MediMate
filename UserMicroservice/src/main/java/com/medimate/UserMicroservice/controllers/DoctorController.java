package com.medimate.UserMicroservice.controllers;

import com.medimate.UserMicroservice.models.Doctor;
import com.medimate.UserMicroservice.services.DoctorService;
import com.medimate.UserMicroservice.viewmodels.DoctorVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public void addDoctor(@Valid @RequestBody DoctorVM doctor) {
        doctorService.addDoctor(doctor);
    }

    @GetMapping
    public ResponseEntity<Page<Doctor>> getAllDoctors(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String title
    ) {
        Page<Doctor> doctors = doctorService.getAllDoctors(page, size, sortBy, firstName, lastName, title);

        return (doctors != null && !doctors.isEmpty()) ? ResponseEntity.ok().body(doctors) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "{id}")
    public Doctor getDoctor(@PathVariable Integer id) {
        return doctorService.getDoctor(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
    }
}

