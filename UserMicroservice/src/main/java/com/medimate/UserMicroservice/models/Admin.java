package com.medimate.UserMicroservice.models;

import jakarta.persistence.*;

@Entity
@Table(name="admins")
public class Admin {

    @Id
    @GeneratedValue
    private Integer id;
    private String first_name;
    private String last_name;
    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    protected Admin(){}
    public Admin(String first_name,String last_name)
    {
        this.first_name=first_name;
        this.last_name=last_name;
    }

    public Integer getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
}
