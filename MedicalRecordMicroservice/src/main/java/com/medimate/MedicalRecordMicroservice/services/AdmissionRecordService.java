package com.medimate.MedicalRecordMicroservice.services;

import com.medimate.MedicalRecordMicroservice.models.AdmissionRecord;
import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import com.medimate.MedicalRecordMicroservice.models.Patient;
import com.medimate.MedicalRecordMicroservice.repositories.AdmissionRecordRepository;
import com.medimate.MedicalRecordMicroservice.viewmodels.AdmissionRecordVM;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionRecordService {

    @Autowired
    private AdmissionRecordRepository admissionRecordRepository;


    public AdmissionRecord addAdmissionRecord(AdmissionRecordVM admissionRecordVM) {
        return admissionRecordRepository.save(AdmissionRecordVM.toEntity(admissionRecordVM));
    }
    public List<AdmissionRecord> getAdmissionRecordsForDoctor(Integer doctorId)
    {
        List<AdmissionRecord> admissionRecords = admissionRecordRepository.findByDoctorId(doctorId);
        admissionRecords.forEach(medicalRecord -> {
            if (medicalRecord.getPatientId() != doctorId) throw new EntityExistsException("Could not find admission record for doctor with id " + doctorId);
        });
        return admissionRecords;
    }
    public List<AdmissionRecord> getAllAdmissionRecords()
    {
        return admissionRecordRepository.findAll();
    }

    public AdmissionRecord getAdmissionRecord(Integer id) {
        return admissionRecordRepository.findById(id).orElseThrow(() -> new EntityExistsException("Could not find admission record with id " + id));
    }
    public void deleteAdmissionRecord(Integer id)
    {
        admissionRecordRepository.deleteById(id);
    }
}
