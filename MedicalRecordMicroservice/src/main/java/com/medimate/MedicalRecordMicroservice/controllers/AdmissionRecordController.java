package com.medimate.MedicalRecordMicroservice.controllers;

import com.medimate.MedicalRecordMicroservice.models.AdmissionRecord;
import com.medimate.MedicalRecordMicroservice.models.Patient;
import com.medimate.MedicalRecordMicroservice.repositories.AdmissionRecordRepository;
import com.medimate.MedicalRecordMicroservice.services.AdmissionRecordService;
import com.medimate.MedicalRecordMicroservice.services.PatientService;
import com.medimate.MedicalRecordMicroservice.viewmodels.AdmissionRecordVM;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/admissionrecord")
public class AdmissionRecordController {

    @Autowired
    private AdmissionRecordService admissionRecordService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private AdmissionRecordRepository repo;

    @PostMapping(path="/add")
    public void addAdmissionRecord(@RequestBody AdmissionRecordVM admissionRecord)
    {
        admissionRecordService.addAdmissionRecord(admissionRecord);
    }
//
//    @GetMapping(path="/getall")
//    public List<AdmissionRecord> getAllAdmissionRecords()
//    {
//        return admissionRecordService.getAllAdmissionRecords();
//    }

    @GetMapping(path="/get/{id}")
    public Patient getAdmissionRecordsForDoctor(@PathVariable Integer id)
    {
        Optional<AdmissionRecord> a = repo.findById(id);
        Integer pomocna = a.get().getPatientId();
       // return admissionRecordService.getAdmissionRecordsForDoctor(id);
        return patientService.getOnePatient(pomocna);
    }

    @DeleteMapping(path="/delete/{id}")
    public void deleteAdmissionRecord(@PathVariable Integer id)
    {
        admissionRecordService.deleteAdmissionRecord(id);
    }
}
