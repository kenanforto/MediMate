package com.medimate.UserMicroservice.models;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue
    private Integer id;

    private String role;
    @OneToOne(mappedBy = "role")
    private User user;

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

    public User getUser() {
        return user;
    }
}
