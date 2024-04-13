package com.medimate.MedicalRecordMicroservice.controllers;

import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import com.medimate.MedicalRecordMicroservice.models.Patient;
import com.medimate.MedicalRecordMicroservice.services.MedicalRecordService;
import com.medimate.MedicalRecordMicroservice.viewmodels.MedicalRecordVM;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "medical-records")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @PostMapping
    public MedicalRecord addMedicalRecord(
            @RequestBody @Valid MedicalRecordVM medicalRecordVM
    ) {
        return medicalRecordService.addMedicalRecord(medicalRecordVM);
    }

    @GetMapping
    public ResponseEntity<Page<MedicalRecord>> getAllMedicalRecords(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<MedicalRecord> medicalRecords = medicalRecordService.getAllMedicalRecords(page, size, sortBy);

        return (medicalRecords != null && !medicalRecords.isEmpty()) ? ResponseEntity.ok().body(medicalRecords) : ResponseEntity.notFound().build();
    }


    @GetMapping(path = "{medicalRecordId}")
    public ResponseEntity<MedicalRecord> getMedicalRecord(
            @PathVariable Integer medicalRecordId
    ) {
        MedicalRecord medicalRecord = medicalRecordService.getMedicalRecord(medicalRecordId);
        return (medicalRecord != null) ? ResponseEntity.ok(medicalRecord) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "patient/{patientId}")
    public ResponseEntity<List<MedicalRecord>> getAllMedicalRecordsForPatient(
            @PathVariable Integer patientId
    ) {
        List<MedicalRecord> medicalRecords = medicalRecordService.getMedicalRecordsForPatient(patientId);
        return (medicalRecords != null) ? ResponseEntity.ok(medicalRecords) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "doctor/{doctorId}")
    public ResponseEntity<List<MedicalRecord>> getAllMedicalRecordsForDoctor(
            @PathVariable Integer doctorId
    ) {
        List<MedicalRecord> medicalRecords = medicalRecordService.getMedicalRecordsForDoctor(doctorId);
        return (medicalRecords != null) ? ResponseEntity.ok(medicalRecords) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "{medicalRecordId}/patient/{patientId}")
    @Transactional
    public ResponseEntity<Void> deleteMedicalRecordForPatient(
            @PathVariable Integer medicalRecordId,
            @PathVariable Integer patientId
    ) {
        medicalRecordService.deleteMedicalRecordForPatient(medicalRecordId, patientId);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "patient/{patientId}")
    @Transactional
    public ResponseEntity<Void> deleteAllMedicalRecordsForPatient(
            @PathVariable Integer patientId
    ) {
        medicalRecordService.deleteAllMedicalRecordsForPatient(patientId);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "{medicalRecordId}")
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable Integer medicalRecordId) {
        medicalRecordService.deleteMedicalRecord(medicalRecordId);

        return ResponseEntity.noContent().build();
    }
}
