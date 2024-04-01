package com.medimate.MedicalRecordMicroservice.controllers;

import com.medimate.MedicalRecordMicroservice.models.AdmissionRecord;
import com.medimate.MedicalRecordMicroservice.services.AdmissionRecordService;
import com.medimate.MedicalRecordMicroservice.viewmodels.AdmissionRecordVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/admission-record")
public class AdmissionRecordController {

    @Autowired
    private AdmissionRecordService admissionRecordService;

    @PostMapping
    public void addAdmissionRecord(@RequestBody AdmissionRecordVM admissionRecord)
    {
        admissionRecordService.addAdmissionRecord(admissionRecord);
    }

    @GetMapping(path = "/all")
    public List<AdmissionRecord> getAllAdmissionRecords()
    {
        return admissionRecordService.getAllAdmissionRecords();
    }

    @GetMapping(path = "/{doctorId}")
    public List<AdmissionRecord> getAdmissionRecordsForDoctor(@PathVariable Integer doctorId)
    {
        return admissionRecordService.getAdmissionRecordsForDoctor(doctorId);
    }

    @DeleteMapping(path="/{id}")
    public void deleteAdmissionRecord(@PathVariable Integer id)
    {
        admissionRecordService.deleteAdmissionRecord(id);
    }
}
