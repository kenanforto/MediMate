package com.medimate.AppointmentMicroservice.controllers;

import com.medimate.AppointmentMicroservice.models.Patient;
import com.medimate.AppointmentMicroservice.service.PatientService;
import com.medimate.AppointmentMicroservice.viewModels.PatientVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping(path = "{id}")
    public Patient getPatient(@Valid @PathVariable Integer id) {
        return patientService.getPatient(id);
    }

    @GetMapping
    public ResponseEntity<Page<Patient>> getAllPatients(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName
    ) {
        Page<Patient> patients = patientService.getAllPatients(page, size, sortBy, firstName, lastName);
        return (patients != null && !patients.isEmpty()) ? ResponseEntity.ok().body(patients) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public void addPatient(@RequestBody PatientVM patient) {
        patientService.addPatient(patient);
    }

    @DeleteMapping(path = "{id}")
    public void deletePatient(@PathVariable Integer id) {
        patientService.deletePatient(id);
    }
}
