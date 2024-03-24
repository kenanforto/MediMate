package com.medimate.AdmissionMicroservice.controllers;

import com.medimate.AdmissionMicroservice.service.PatientService;
import com.medimate.AdmissionMicroservice.viewModels.PatientVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="patient")
public class PatientController {

    @Autowired
    PatientService patientService;
    @PostMapping(path="/add")
    public void savePatient(@RequestBody PatientVM patient) {
        patientService.savePatient(patient);
    }
}
