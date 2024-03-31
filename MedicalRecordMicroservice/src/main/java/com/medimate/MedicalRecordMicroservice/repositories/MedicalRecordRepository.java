package com.medimate.MedicalRecordMicroservice.repositories;

import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Integer> {
    List<MedicalRecord> findByPatientId(Integer patientId);

    List<MedicalRecord> findByDoctorId(Integer doctorId);

    void deleteByPatientId(Integer patientId);
}
