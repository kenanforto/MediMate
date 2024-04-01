package com.medimate.WorkingHoursMicroservice.repositories;

import com.medimate.WorkingHoursMicroservice.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {


}
