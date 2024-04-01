package com.medimate.MedicalRecordMicroservice.repositories;

import com.medimate.MedicalRecordMicroservice.models.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Integer> {
    List<MedicalRecord> findByPatientId(Integer patientId);

    List<MedicalRecord> findByDoctorId(Integer doctorId);

    @Modifying
    @Query("DELETE FROM MedicalRecord AS mr WHERE mr.id = :medicalRecordId AND mr.patientId = :patientId")
    void deleteByPatientId(@Param("medicalRecordId") Integer medicalRecordId,
                           @Param("patientId") Integer patientId);

    void deleteAllByPatientId(Integer patientId);
}
