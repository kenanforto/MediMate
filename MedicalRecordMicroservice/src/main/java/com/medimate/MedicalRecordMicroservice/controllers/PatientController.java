package com.medimate.MedicalRecordMicroservice.controllers;

import com.medimate.MedicalRecordMicroservice.models.Patient;
import com.medimate.MedicalRecordMicroservice.services.PatientService;
import com.medimate.MedicalRecordMicroservice.viewmodels.PatientVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(path="{id}")
    public Patient getOnePatient(@PathVariable Integer id)
    {
        return patientService.getOnePatient(id);
    }
    @GetMapping(path="/all")
    public List<Patient> getAllPatients()
    {
        return patientService.getAllPatients();
    }
    @PostMapping
    public void addPatient(@RequestBody PatientVM patient)
    {
        patientService.addPatient(patient);
    }
    @DeleteMapping(path="{id}")
    public void deleteOnePatient(@PathVariable Integer id)
    {
        patientService.deleteOnePatient(id);
    }
}
