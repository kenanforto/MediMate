package com.medimate.SuppliesMicroservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @Column(name = "admin_id")
    @NotNull
    private Integer adminId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "admin_id", insertable = false, updatable = false)
    private Admin admin;

    public Supplies(String medicationName, Integer amount, Integer adminId) {
        this.medicationName = medicationName;
        this.amount = amount;
        this.adminId = adminId;
    }
}
