package com.medimate.MedicalRecordMicroservice.controllers;

import com.medimate.MedicalRecordMicroservice.models.Doctor;
import com.medimate.MedicalRecordMicroservice.services.DoctorService;
import com.medimate.MedicalRecordMicroservice.viewmodels.DoctorVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/doctor")
public class DoctorController{

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public Doctor addDoctor(@RequestBody @Valid DoctorVM doctor) {
        return doctorService.addDoctor(doctor);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Doctor>> getAllDoctors()
    {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return (doctors != null) ? ResponseEntity.ok(doctors) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Integer id)
    {
        Doctor doctor = doctorService.getDoctor(id);
        return (doctor != null) ? ResponseEntity.ok(doctor) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Integer id)
    {
        doctorService.deleteDoctor(id);

        return ResponseEntity.noContent().build();
    }
}
