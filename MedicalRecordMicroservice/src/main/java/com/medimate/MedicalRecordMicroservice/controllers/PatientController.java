package com.medimate.MedicalRecordMicroservice.controllers;

import com.medimate.MedicalRecordMicroservice.models.Patient;
import com.medimate.MedicalRecordMicroservice.services.PatientService;
import com.medimate.MedicalRecordMicroservice.viewmodels.PatientVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(path = "{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Integer id)
    {
        Patient patient = patientService.getPatient(id);
        return (patient != null) ? ResponseEntity.ok(patient) : ResponseEntity.notFound().build();
    }

    @GetMapping(path="/all")
    public ResponseEntity<List<Patient>> getAllPatients()
    {
        List<Patient> patients = patientService.getAllPatients();
        return (patients != null) ? ResponseEntity.ok(patients) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Patient addPatient(@RequestBody @Valid PatientVM patient)
    {
        return patientService.addPatient(patient);
    }

    @DeleteMapping(path="{id}")
    public ResponseEntity<Void> deleteOnePatient(@PathVariable Integer id)
    {
        patientService.deleteOnePatient(id);

        return ResponseEntity.noContent().build();
    }
}
