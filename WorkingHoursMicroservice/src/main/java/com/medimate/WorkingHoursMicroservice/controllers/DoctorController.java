package com.medimate.WorkingHoursMicroservice.controllers;

import com.medimate.WorkingHoursMicroservice.models.Doctor;
import com.medimate.WorkingHoursMicroservice.services.DoctorService;
import com.medimate.WorkingHoursMicroservice.viewmodels.DoctorVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("")
    public void addOne(@RequestBody DoctorVM doctorVM){
        doctorService.addOne(doctorVM);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id){
        doctorService.deleteById(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<Doctor> getById(@PathVariable Integer id){
        Doctor doctor = doctorService.getById(id);
        if (doctor != null) {
            return ResponseEntity.ok(doctor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
