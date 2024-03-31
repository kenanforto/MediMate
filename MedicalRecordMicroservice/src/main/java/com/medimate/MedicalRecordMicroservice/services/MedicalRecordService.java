package com.medimate.MedicalRecordMicroservice.services;

import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import com.medimate.MedicalRecordMicroservice.repositories.MedicalRecordRepository;
import com.medimate.MedicalRecordMicroservice.viewmodels.MedicalRecordVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public void addMedicalRecord(MedicalRecordVM mr)
    {
        MedicalRecord pomocna = MedicalRecordVM.toEntity(mr);
        System.out.println("pomocna "+pomocna);
        medicalRecordRepository.save(pomocna);

    }
    public List<MedicalRecord> getAllMedicalRecords()
    {

        return medicalRecordRepository.findAll();
    }
    public List<MedicalRecord> getMedicalRecordsForPatient(Integer id)
    {
        return medicalRecordRepository.findByPatientId(id);
    }

    public List<MedicalRecord> getMedicalRecordsForDoctor(Integer id)
    {
        return medicalRecordRepository.findByDoctorId(id);
    }

    public void deleteMedicalRecordForPatient(Integer id)
    {
        medicalRecordRepository.deleteByPatientId(id);
    }

    public void deleteMedicalRecord(Integer id)
    {
        medicalRecordRepository.deleteById(id);
    }
}
