package com.medimate.UserMicroservice.models;

import com.medimate.UserMicroservice.models.Admin;
import com.medimate.UserMicroservice.models.Doctor;
import com.medimate.UserMicroservice.models.Role;
import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String userName;
    private String password;
    @OneToOne
    @JoinColumn(name="role_id",referencedColumnName = "id")
    private Role role;

    protected User()
    {

    }

    public User( String user_name, String password, Role role) {
        this.userName = user_name;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Role getRole() {
        return role;
    }
}
