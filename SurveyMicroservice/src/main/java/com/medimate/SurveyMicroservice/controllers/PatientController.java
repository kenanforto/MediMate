package com.medimate.SurveyMicroservice.controllers;

import com.medimate.SurveyMicroservice.models.Patient;
import com.medimate.SurveyMicroservice.services.PatientService;
import com.medimate.SurveyMicroservice.viewModels.PatientVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/patient")

public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping(path = "/get/{id}")
    public Patient getOnePatient(@PathVariable Integer id) {
        return patientService.getOnePatient(id);
    }

    @GetMapping
    public ResponseEntity<Page<Patient>> getAllPatients(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<Patient> patients = patientService.getAllPatients(page, size, sortBy);

        return (patients != null && !patients.isEmpty()) ? ResponseEntity.ok().body(patients) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public void addPatient(@RequestBody PatientVM patient) {
        patientService.addPatient(patient);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteOnePatient(@PathVariable Integer id) {
        patientService.deleteOnePatient(id);
    }
}
