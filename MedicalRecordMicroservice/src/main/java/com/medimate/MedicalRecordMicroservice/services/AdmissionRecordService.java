package com.medimate.MedicalRecordMicroservice.services;

import com.medimate.MedicalRecordMicroservice.models.AdmissionRecord;
import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import com.medimate.MedicalRecordMicroservice.models.Patient;
import com.medimate.MedicalRecordMicroservice.repositories.AdmissionRecordRepository;
import com.medimate.MedicalRecordMicroservice.viewmodels.AdmissionRecordVM;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionRecordService {

    @Autowired
    private AdmissionRecordRepository admissionRecordRepository;


    public AdmissionRecord addAdmissionRecord(AdmissionRecordVM admissionRecordVM) {
        return admissionRecordRepository.save(AdmissionRecordVM.toEntity(admissionRecordVM));
    }

    public List<AdmissionRecord> getAdmissionRecordsForDoctor(Integer doctorId) {
        List<AdmissionRecord> admissionRecords = admissionRecordRepository.findByDoctorId(doctorId);

        if (admissionRecords.isEmpty())
            throw new EntityExistsException("Could not find admission record for doctor with id " + doctorId);

        return admissionRecords;
    }

    public Page<AdmissionRecord> getAllAdmissionRecords(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<AdmissionRecord> admissionRecords = admissionRecordRepository.findAll(pageable);
        if (admissionRecords.isEmpty()) {
            throw new EntityNotFoundException("There are no admission records");
        }
        return admissionRecords;
    }

    public AdmissionRecord getAdmissionRecord(Integer id) {
        return admissionRecordRepository.findById(id).orElseThrow(() -> new EntityExistsException("Could not find admission record with id " + id));
    }

    public void deleteAdmissionRecord(Integer id) {
        admissionRecordRepository.deleteById(id);
    }
}
