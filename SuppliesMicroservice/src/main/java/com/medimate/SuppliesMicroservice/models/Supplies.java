package com.medimate.SuppliesMicroservice.models;

import jakarta.persistence.*;

@Entity
@Table(name="supplies")
public class Supplies {
    @Id
    @GeneratedValue
    private Integer id;
    private String medicationName;
    private Integer amount;

    @ManyToOne
    @JoinColumn(name="admin_id")
    private Admin admin;

    protected Supplies(){}

    public Supplies(Integer id, String medicationName, Integer amount) {
        this.id = id;
        this.medicationName = medicationName;
        this.amount = amount;
    }
}
