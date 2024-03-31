package com.medimate.MedicalRecordMicroservice.repositories;

import com.medimate.MedicalRecordMicroservice.models.AdmissionRecord;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecord,Integer> {
    List<AdmissionRecord> findByDoctorId(Integer doctorId);
}
