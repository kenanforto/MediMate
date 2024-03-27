package com.medimate.MedicalRecordMicroservice.services;

import com.medimate.MedicalRecordMicroservice.models.AdmissionRecord;
import com.medimate.MedicalRecordMicroservice.repositories.AdmissionRecordRepository;
import com.medimate.MedicalRecordMicroservice.repositories.DoctorRepository;
import com.medimate.MedicalRecordMicroservice.repositories.PatientRepository;
import com.medimate.MedicalRecordMicroservice.viewmodels.AdmissionRecordVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionRecordService {
    @Autowired
    private AdmissionRecordRepository repo;
    @Autowired
    private PatientRepository repoPatient;
    @Autowired
    private DoctorRepository repoDoctor;


    public void addAdmissionRecord(AdmissionRecordVM admissionRecord)
    {
        repo.save( new AdmissionRecord(
                admissionRecord.getAdmittedAt(),
                admissionRecord.isUrgent(),
                repoDoctor.findById(admissionRecord.getDoctorId()).orElse(null),
                repoPatient.findById(admissionRecord.getPatientId()).orElse(null)));
    }
    public List<AdmissionRecord> getAdmissionRecordsForDoctor(Integer id)
    {
        return repo.findByDoctorId(id);
    }
    public List<AdmissionRecord> getAllAdmissionRecords()
    {
        return repo.findAll();
    }
    public void deleteAdmissionRecord(Integer id)
    {
        repo.deleteById(id);
    }


}
