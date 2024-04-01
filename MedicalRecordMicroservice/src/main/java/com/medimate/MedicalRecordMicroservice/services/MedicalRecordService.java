package com.medimate.MedicalRecordMicroservice.services;

import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import com.medimate.MedicalRecordMicroservice.repositories.MedicalRecordRepository;
import com.medimate.MedicalRecordMicroservice.viewmodels.MedicalRecordVM;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecord addMedicalRecord(MedicalRecordVM medicalRecordVM)
    {
        return medicalRecordRepository.save(MedicalRecordVM.toEntity(medicalRecordVM));

    }

    public MedicalRecord getMedicalRecord(Integer id)
    {
        return medicalRecordRepository.findById(id).orElseThrow(() -> new EntityExistsException("Could not find medical record with id " + id));
    }
    public List<MedicalRecord> getAllMedicalRecords()
    {

        return medicalRecordRepository.findAll();
    }
    public List<MedicalRecord> getMedicalRecordsForPatient(Integer patientId)
    {
        List<MedicalRecord> medicalRecords = medicalRecordRepository.findByPatientId(patientId);

        if(medicalRecords.isEmpty()) throw new EntityExistsException("Could not find medical record with patient id " + patientId);

        return medicalRecords;
    }

    public List<MedicalRecord> getMedicalRecordsForDoctor(Integer doctorId)
    {
        List<MedicalRecord> medicalRecords = medicalRecordRepository.findByDoctorId(doctorId);

        if(medicalRecords.isEmpty()) throw new EntityExistsException("Could not find medical record for doctor with id " + doctorId);

        return medicalRecords;
    }

    public void deleteMedicalRecordForPatient(Integer id, Integer patientId)
    {
        medicalRecordRepository.deleteByPatientId(id, patientId);
    }

    public void deleteAllMedicalRecordsForPatient(Integer patientId)
    {
        medicalRecordRepository.deleteAllByPatientId(patientId);
    }

    public void deleteMedicalRecord(Integer id)
    {
            medicalRecordRepository.deleteById(id);
    }
}
