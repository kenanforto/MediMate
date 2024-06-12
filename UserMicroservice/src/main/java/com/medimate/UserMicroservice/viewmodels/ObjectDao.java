package com.medimate.UserMicroservice.viewmodels;

import com.medimate.UserMicroservice.models.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectDao {
    Integer id;
    String firstName;
    Role role;
}
