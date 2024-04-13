package com.medimate.SuppliesMicroservice.repositories;

import com.medimate.SuppliesMicroservice.models.Admin;
import com.medimate.SuppliesMicroservice.viewmodels.AdminVM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Page<Admin> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName, Pageable pageable);
    Page<Admin> findByFirstNameContaining(String firstName, Pageable pageable);
    Page<Admin> findByLastNameContaining(String lastName, Pageable pageable);
}
