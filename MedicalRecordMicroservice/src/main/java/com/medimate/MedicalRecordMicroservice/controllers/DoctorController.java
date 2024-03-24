package com.medimate.MedicalRecordMicroservice.controllers;

import com.medimate.MedicalRecordMicroservice.services.DoctorService;
import com.medimate.MedicalRecordMicroservice.viewmodels.DoctorVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="doctor")
public class DoctorController{

    @Autowired
    DoctorService doctorService;
    @PostMapping(path="/add")
    public void saveDoctor(@RequestBody DoctorVM doctor) {
        //Doctor korisnik = new Doctor(1, "Kenan", "Forto", "doca");
        doctorService.saveDoctor(doctor);
    }
}
