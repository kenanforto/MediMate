package com.medimate.UserMicroservice.models;

import jakarta.persistence.*;

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue
    private Integer id;

    private String role;

    protected Role() { }
    public Role(String role)
    {
        this.role=role;
    }

    public Integer getId() {
        return id;
    }

    public String getRole() {
        return role;
    }
}
