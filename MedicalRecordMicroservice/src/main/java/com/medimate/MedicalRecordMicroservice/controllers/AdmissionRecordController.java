package com.medimate.MedicalRecordMicroservice.controllers;

import com.medimate.MedicalRecordMicroservice.models.AdmissionRecord;
import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import com.medimate.MedicalRecordMicroservice.services.AdmissionRecordService;
import com.medimate.MedicalRecordMicroservice.viewmodels.AdmissionRecordVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/admission-record")
public class AdmissionRecordController {

    @Autowired
    private AdmissionRecordService admissionRecordService;

    @PostMapping
    public AdmissionRecord addAdmissionRecord(@RequestBody @Valid AdmissionRecordVM admissionRecordVM)
    {
       return admissionRecordService.addAdmissionRecord(admissionRecordVM);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<AdmissionRecord>> getAllAdmissionRecords()
    {
        List<AdmissionRecord> admissionRecords = admissionRecordService.getAllAdmissionRecords();
        return (admissionRecords != null) ? ResponseEntity.ok(admissionRecords) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AdmissionRecord> getAdmissionRecord(
            @PathVariable Integer id
    )
    {
        AdmissionRecord admissionRecord = admissionRecordService.getAdmissionRecord(id);
        return (admissionRecord != null) ? ResponseEntity.ok(admissionRecord) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/{doctorId}")
    public List<AdmissionRecord> getAdmissionRecordsForDoctor(@PathVariable Integer doctorId)
    {
        return admissionRecordService.getAdmissionRecordsForDoctor(doctorId);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deleteAdmissionRecord(@PathVariable Integer id)
    {
        admissionRecordService.deleteAdmissionRecord(id);

        return ResponseEntity.noContent().build();
    }
}
