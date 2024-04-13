package com.medimate.WorkingHoursMicroservice.controllers;

import com.medimate.WorkingHoursMicroservice.models.Doctor;
import com.medimate.WorkingHoursMicroservice.services.DoctorService;
import com.medimate.WorkingHoursMicroservice.viewmodels.DoctorVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping
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

    @GetMapping
    public ResponseEntity<Page<Doctor>> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String title
    ) {
        Page<Doctor> doctors = doctorService.getAll(page, size, sortBy, firstName, lastName, title);

        return (doctors != null && !doctors.isEmpty()) ? ResponseEntity.ok().body(doctors) : ResponseEntity.notFound().build();
    }


    @PutMapping("{id}")
    public ResponseEntity<Doctor> updateAdmin(@PathVariable Integer id, @RequestBody DoctorVM doctorVM) {
        Doctor updatedDoctor = doctorService.updateById(id, doctorVM);
        return ResponseEntity.ok(updatedDoctor);
    }
}
