package com.medimate.WorkingHoursMicroservice.repositories;

import com.medimate.WorkingHoursMicroservice.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
