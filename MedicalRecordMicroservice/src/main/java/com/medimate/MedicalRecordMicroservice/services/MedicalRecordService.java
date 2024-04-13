package com.medimate.MedicalRecordMicroservice.services;

import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import com.medimate.MedicalRecordMicroservice.models.Patient;
import com.medimate.MedicalRecordMicroservice.repositories.MedicalRecordRepository;
import com.medimate.MedicalRecordMicroservice.repositories.PatientRepository;
import com.medimate.MedicalRecordMicroservice.viewmodels.MedicalRecordVM;
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
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private PatientRepository patientRepository;

    public MedicalRecord addMedicalRecord(MedicalRecordVM medicalRecordVM) {
        return medicalRecordRepository.save(MedicalRecordVM.toEntity(medicalRecordVM));

    }

    public MedicalRecord getMedicalRecord(Integer id) {
        return medicalRecordRepository.findById(id).orElseThrow(() -> new EntityExistsException("Could not find medical record with id " + id));
    }

    public Page<MedicalRecord> getAllMedicalRecords(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<MedicalRecord> medicalRecords = medicalRecordRepository.findAll(pageable);
        if (medicalRecords.isEmpty()) {
            throw new EntityNotFoundException("There are no medical records");
        }
        return medicalRecords;
    }

    public List<MedicalRecord> getMedicalRecordsForPatient(Integer patientId) {
        List<MedicalRecord> medicalRecords = medicalRecordRepository.findByPatientId(patientId);

        if (medicalRecords.isEmpty())
            throw new EntityExistsException("Could not find medical record with patient id " + patientId);

        return medicalRecords;
    }

    public List<MedicalRecord> getMedicalRecordsForDoctor(Integer doctorId) {
        List<MedicalRecord> medicalRecords = medicalRecordRepository.findByDoctorId(doctorId);

        if (medicalRecords.isEmpty())
            throw new EntityExistsException("Could not find medical record for doctor with id " + doctorId);

        return medicalRecords;
    }

    public void deleteMedicalRecordForPatient(Integer id, Integer patientId) {
        if (patientRepository.findById(patientId).orElse(null) == null) {
            throw new EntityExistsException("Could not find patient with id " + patientId);
        }

        if (medicalRecordRepository.findById(id).orElse(null) == null) {
            throw new EntityExistsException("Could not find medical record with id " + patientId);
        }

        medicalRecordRepository.deleteByPatientId(id, patientId);
    }

    public void deleteAllMedicalRecordsForPatient(Integer patientId) {
        if (patientRepository.findById(patientId).orElse(null) == null) {
            throw new EntityExistsException("Could not find patient with id " + patientId);
        }
        medicalRecordRepository.deleteAllByPatientId(patientId);
    }

    public void deleteMedicalRecord(Integer id) {
        if (medicalRecordRepository.findById(id).orElse(null) == null) {
            throw new EntityExistsException("Could not find medical record with id " + id);
        }
        medicalRecordRepository.deleteById(id);
    }
}
