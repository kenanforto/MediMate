package com.medimate.MedicalRecordMicroservice.controllers;

import com.medimate.MedicalRecordMicroservice.models.Doctor;
import com.medimate.MedicalRecordMicroservice.services.DoctorService;
import com.medimate.MedicalRecordMicroservice.viewmodels.DoctorVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public Doctor addDoctor(@RequestBody @Valid DoctorVM doctor) {
        return doctorService.addDoctor(doctor);
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
    public ResponseEntity<Doctor> getDoctor(@PathVariable Integer id) {
        Doctor doctor = doctorService.getDoctor(id);
        return (doctor != null) ? ResponseEntity.ok(doctor) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);

        return ResponseEntity.noContent().build();
    }
}
