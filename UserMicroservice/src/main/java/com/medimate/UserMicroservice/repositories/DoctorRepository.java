package com.medimate.UserMicroservice.repositories;

import com.medimate.UserMicroservice.models.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
//    Page<Doctor> findByFirstNameContainingAndLastNameContainingAndTitleContaining(String firstName, String lastName, String title, Pageable pageable);
//
//    Page<Doctor> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName, Pageable pageable);
//
//    Page<Doctor> findByFirstNameContainingAndTitleContaining(String firstName, String title, Pageable pageable);
//
//    Page<Doctor> findByLastNameContainingAndTitleContaining(String lastName, String title, Pageable pageable);
//
//    Page<Doctor> findByFirstNameContaining(String firstName, Pageable pageable);
//
//    Page<Doctor> findByLastNameContaining(String lastName, Pageable pageable);

    Page<Doctor> findByTitleContaining(String title, Pageable pageable);
}
