package com.medimate.MedicalRecordMicroservice.services;

import com.medimate.MedicalRecordMicroservice.models.AdmissionRecord;
import com.medimate.MedicalRecordMicroservice.repositories.AdmissionRecordRepository;
import com.medimate.MedicalRecordMicroservice.viewmodels.AdmissionRecordVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionRecordService {

    @Autowired
    private AdmissionRecordRepository admissionRecordRepository;


    public void addAdmissionRecord(AdmissionRecordVM admissionRecord) {
        admissionRecordRepository.save(new AdmissionRecord(
                admissionRecord.getAdmittedAt(),
                admissionRecord.isUrgent(),
                admissionRecord.getDoctorId(),
                admissionRecord.getPatientId())
        );
    }
    public List<AdmissionRecord> getAdmissionRecordsForDoctor(Integer id)
    {
        return admissionRecordRepository.findByDoctorId(id);
    }
    public List<AdmissionRecord> getAllAdmissionRecords()
    {
        return admissionRecordRepository.findAll();
    }
    public void deleteAdmissionRecord(Integer id)
    {
        admissionRecordRepository.deleteById(id);
    }
}
