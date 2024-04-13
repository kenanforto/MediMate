package com.medimate.MedicalRecordMicroservice.controllers;

import com.medimate.MedicalRecordMicroservice.models.AdmissionRecord;
import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import com.medimate.MedicalRecordMicroservice.models.Patient;
import com.medimate.MedicalRecordMicroservice.services.AdmissionRecordService;
import com.medimate.MedicalRecordMicroservice.viewmodels.AdmissionRecordVM;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "admission-records")
public class AdmissionRecordController {

    @Autowired
    private AdmissionRecordService admissionRecordService;

    @PostMapping
    public AdmissionRecord addAdmissionRecord(@RequestBody @Valid AdmissionRecordVM admissionRecordVM) {
        return admissionRecordService.addAdmissionRecord(admissionRecordVM);
    }

    @GetMapping
    public ResponseEntity<Page<AdmissionRecord>> getAllAdmissionRecords(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<AdmissionRecord> admissionRecords = admissionRecordService.getAllAdmissionRecords(page, size, sortBy);

        return (admissionRecords != null && !admissionRecords.isEmpty()) ? ResponseEntity.ok().body(admissionRecords) : ResponseEntity.notFound().build();
    }


    @GetMapping(path = "{id}")
    public ResponseEntity<AdmissionRecord> getAdmissionRecord(
            @PathVariable Integer id
    ) {
        AdmissionRecord admissionRecord = admissionRecordService.getAdmissionRecord(id);
        return (admissionRecord != null) ? ResponseEntity.ok(admissionRecord) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "{doctorId}")
    public List<AdmissionRecord> getAdmissionRecordsForDoctor(@PathVariable Integer doctorId) {
        return admissionRecordService.getAdmissionRecordsForDoctor(doctorId);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteAdmissionRecord(@PathVariable Integer id) {
        admissionRecordService.deleteAdmissionRecord(id);

        return ResponseEntity.noContent().build();
    }
}
