package com.medimate.UserMicroservice.models;

import jakarta.persistence.*;

@Entity
@Table(name="admin")
public class Admin {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    protected Admin(){}
    public Admin(String first_name,String last_name)
    {
        this.firstName=first_name;
        this.lastName=last_name;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
