package com.medimate.AdmissionMicroservice.controllers;

import com.medimate.AdmissionMicroservice.models.Patient;
import com.medimate.AdmissionMicroservice.service.PatientService;
import com.medimate.AdmissionMicroservice.viewModels.PatientVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping(path="/get/{id}")
    public Patient getOnePatient(@PathVariable Integer id)
    {
        return patientService.getOnePatient(id);
    }
    @GetMapping(path="/getall")
    public List<Patient> getAllPatients()
    {
        return patientService.getAllPatients();
    }
    @PostMapping(path="/add")
    public void addPatient(@RequestBody PatientVM patient)
    {
        patientService.addPatient(patient);
    }
    @DeleteMapping(path="/delete/{id}")
    public void deleteOnePatient(@PathVariable Integer id)
    {
        patientService.deleteOnePatient(id);
    }
}
