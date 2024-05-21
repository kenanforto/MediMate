package com.medimate.SuppliesMicroservice.repositories;

import com.medimate.SuppliesMicroservice.models.Admin;
import com.medimate.SuppliesMicroservice.models.Supplies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliesRepository extends JpaRepository<Supplies, Integer> {

}
