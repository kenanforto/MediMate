package com.medimate.SuppliesMicroservice.repositories;

import com.medimate.SuppliesMicroservice.models.Supplies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuppliesRepository extends JpaRepository<Supplies, Integer> {

}
