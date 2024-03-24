package com.medimate.MedicalRecordMicroservice.controllers;

import com.medimate.MedicalRecordMicroservice.viewmodels.AdmissionRecordVM;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="admissionrecord")
public class AdmissionRecordController {


    @PostMapping(path="/add")
    public void addAdmissionRecord(@RequestBody AdmissionRecordVM admissionRecord)
    {

    }


    @DeleteMapping(path="/delete")
    public void deleteAdmissionRecord()
    {

    }
}
