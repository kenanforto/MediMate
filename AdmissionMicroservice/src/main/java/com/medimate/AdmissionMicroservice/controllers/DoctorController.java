package com.medimate.AdmissionMicroservice.controllers;

import com.medimate.AdmissionMicroservice.models.Doctor;
import com.medimate.AdmissionMicroservice.repositories.DoctorRepository;
import com.medimate.AdmissionMicroservice.service.DoctorService;
import com.medimate.AdmissionMicroservice.viewModels.DoctorVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping(path="/add")
    public void addDoctor(@RequestBody DoctorVM doctor)
    {
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
