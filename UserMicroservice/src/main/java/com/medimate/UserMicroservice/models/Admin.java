package com.medimate.UserMicroservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="admin")
public class Admin {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    private User user;

    public Admin(Integer userId) {
        this.userId=userId;
    }
}
