package com.medimate.MedicalRecordMicroservice.controllers;

import com.medimate.MedicalRecordMicroservice.models.Doctor;
import com.medimate.MedicalRecordMicroservice.services.DoctorService;
import com.medimate.MedicalRecordMicroservice.viewmodels.DoctorVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/doctor")
public class DoctorController{

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public void addDoctor(@RequestBody DoctorVM doctor) {
        doctorService.addDoctor(doctor);
    }
    @GetMapping(path="/all")
    public List<Doctor> getAllDoctors()
    {
        return doctorService.getAllDoctors();
    }
    @GetMapping(path="/{id}")
    public Doctor getOneDoctor(@PathVariable Integer id)
    {
        return doctorService.getDoctor(id);
    }
    @DeleteMapping(path="/{id}")
    public void deleteOneDoctor(@PathVariable Integer id)
    {
        doctorService.deleteDoctor(id);
    }
}
