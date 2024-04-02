package com.medimate.SuppliesMicroservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "supplies")
public class Supplies {
    @Id
    @GeneratedValue
    private Integer id;
    private String medicationName;
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public Supplies(String medicationName, Integer amount, Admin admin) {
        this.medicationName = medicationName;
        this.amount = amount;
        this.admin = admin;
    }
}
