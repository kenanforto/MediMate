package com.medimate.UserMicroservice.services;

import com.medimate.UserMicroservice.models.Role;
import com.medimate.UserMicroservice.repositories.RoleRepository;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role addRole(Role role) {
        Role _role = roleRepository.save(new Role(role.getRole()));
        return _role;
    }


    public Role updateRole(Integer id, Role role) {
        Role _role = roleRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Role with id = " + id + " does not exist!"));
        _role.setRole(role.getRole());
        return roleRepository.save(_role);
    }


    public void deleteRole(Integer id) {
        if(id == null) {
            roleRepository.deleteAll();
            return;
        }
        if (!roleRepository.existsById(id)) {
            throw new NotFoundException("Role with id = " + id + " does not exist!");
        }
        roleRepository.deleteById(id);
        return;
    }


    public Role getRole(String name) {
        return roleRepository.findByRole(name);
    }


    public Role getRole(Integer id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Role with id = " + id + " does not exist!"));
        return role;
    }
}
