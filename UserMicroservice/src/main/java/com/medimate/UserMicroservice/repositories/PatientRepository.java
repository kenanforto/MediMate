package com.medimate.UserMicroservice.repositories;

import com.medimate.UserMicroservice.models.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    Patient findByUserId(Integer userId);
//    Page<Patient> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName, Pageable pageable);
//    Page<Patient> findByFirstNameContaining(String firstName, Pageable pageable);
//    Page<Patient> findByLastNameContaining(String lastName, Pageable pageable);
}