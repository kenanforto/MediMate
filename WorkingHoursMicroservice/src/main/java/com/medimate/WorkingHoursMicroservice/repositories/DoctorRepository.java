package com.medimate.WorkingHoursMicroservice.repositories;

import com.medimate.WorkingHoursMicroservice.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
