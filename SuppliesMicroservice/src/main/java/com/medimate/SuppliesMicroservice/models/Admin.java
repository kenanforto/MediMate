package com.medimate.SuppliesMicroservice.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="admin")
public class Admin {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "admin")
    private List<Supplies> supplies;

    protected Admin(){}

    public Admin(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
