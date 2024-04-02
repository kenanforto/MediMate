package com.medimate.SuppliesMicroservice.repositories;

import com.medimate.SuppliesMicroservice.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {


}
