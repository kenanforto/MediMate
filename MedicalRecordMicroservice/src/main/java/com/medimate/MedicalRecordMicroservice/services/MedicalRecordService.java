package com.medimate.MedicalRecordMicroservice.services;

import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import com.medimate.MedicalRecordMicroservice.repositories.AdmissionRecordRepository;
import com.medimate.MedicalRecordMicroservice.repositories.DoctorRepository;
import com.medimate.MedicalRecordMicroservice.repositories.MedicalRecordRepository;
import com.medimate.MedicalRecordMicroservice.repositories.PatientRepository;
import com.medimate.MedicalRecordMicroservice.viewmodels.MedicalRecordVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AdmissionRecordRepository repoAdmission;
    //dodaj nalaz
    //daj nalaze za jednog pacijenta
    //daj sve nalaze za jednog doktora
    //obrisi nalaz

    public void addMedicalRecord(MedicalRecordVM mr)
    {
//        medicalRecordRepository.save(
//                new MedicalRecord(mr.getDescription(),
//                        doctorRepository.findById(mr.getDoctorId()).orElse(null),
//                        patientRepository.findById(mr.getPatientId()).orElse(null),
//                        repoAdmission.findById(mr.getAdmissionId()).orElse(null))
//        );
        medicalRecordRepository.save(MedicalRecordVM.toEntity(mr));

    }
    public List<MedicalRecord> getAllMedicalRecords()
    {
        return medicalRecordRepository.findAll();
    }
    public List<MedicalRecord> getMedicalRecordsForPatient(Integer id)
    {
        return medicalRecordRepository.findByPatientId(id);
    }
}
