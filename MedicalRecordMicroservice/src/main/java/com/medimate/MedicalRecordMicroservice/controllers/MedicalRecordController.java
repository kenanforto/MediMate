package com.medimate.MedicalRecordMicroservice.controllers;

import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import com.medimate.MedicalRecordMicroservice.services.MedicalRecordService;
import com.medimate.MedicalRecordMicroservice.viewmodels.MedicalRecordVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/medicalrecord")
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService mrService;

    @PostMapping(path="/add")
    public void addMedicalRecord(@RequestBody MedicalRecordVM medicalRecord)
    {
        mrService.addMedicalRecord(medicalRecord);
    }
    @GetMapping(path="/getall")
    public List<MedicalRecord> getAllMedicalRecords()
    {
        return mrService.getAllMedicalRecords();
    }
    @GetMapping(path="/get/{id}")
    public List<MedicalRecord> getMedicalRecordsForPatient(@PathVariable Integer id)
    {
        return mrService.getMedicalRecordsForPatient(id);
    }
}
