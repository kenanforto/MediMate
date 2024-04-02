package com.medimate.UserMicroservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Name of role is mandatory")
    private String role;

    @JsonIgnore
    @OneToOne(mappedBy = "role")
    private User user;

    public Role(String role)
    {
        this.role=role;
    }
}
