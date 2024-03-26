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
    @PostMapping(path="/add")
    public void addDoctor(@RequestBody DoctorVM doctor) {
        //Doctor korisnik = new Doctor(1, "Kenan", "Forto", "doca");
        doctorService.addDoctor(doctor);
    }
    @GetMapping(path="/getall")
    public List<Doctor> getAllDoctors()
    {
        return doctorService.getAllDoctors();
    }
    @GetMapping(path="/get/{id}")
    public Doctor getOneDoctor(@PathVariable Integer id)
    {
        return doctorService.getOneDoctor(id);
    }
    @DeleteMapping(path="/delete/{id}")
    public void deleteOneDoctor(@PathVariable Integer id)
    {
        doctorService.deleteOneDoctor(id);
    }
}
