package com.medimate.MedicalRecordMicroservice.controllers;

import com.medimate.MedicalRecordMicroservice.models.AdmissionRecord;
import com.medimate.MedicalRecordMicroservice.services.AdmissionRecordService;
import com.medimate.MedicalRecordMicroservice.viewmodels.AdmissionRecordVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="admissionrecord")
public class AdmissionRecordController {

    @Autowired
    private AdmissionRecordService admissionRecordService;

    @PostMapping(path="/add")
    public void addAdmissionRecord(@RequestBody AdmissionRecordVM admissionRecord)
    {
        admissionRecordService.addAdmissionRecord(admissionRecord);
    }

    @GetMapping(path="/getall")
    public List<AdmissionRecord> getAllAdmissionRecords()
    {
        return admissionRecordService.getAllAdmissionRecords();
    }

    @GetMapping(path="/get/{id}")
    public List<AdmissionRecord> getAdmissionRecordsForDoctor(@PathVariable Integer id)
    {
        return admissionRecordService.getAdmissionRecordsForDoctor(id);
    }

    @DeleteMapping(path="/delete/{id}")
    public void deleteAdmissionRecord(@PathVariable Integer id)
    {
        admissionRecordService.deleteAdmissionRecord(id);
    }
}
