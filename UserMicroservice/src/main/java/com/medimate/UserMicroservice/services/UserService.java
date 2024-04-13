package com.medimate.UserMicroservice.services;

import com.medimate.UserMicroservice.models.Role;
import com.medimate.UserMicroservice.models.User;
import com.medimate.UserMicroservice.repositories.RoleRepository;
import com.medimate.UserMicroservice.repositories.UserRepository;
import com.medimate.UserMicroservice.viewmodels.UserVM;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public User createUser(UserVM userVM) {
        List<User> pomocna = userRepository.findByUserNameOrEmail(userVM.getUserName(), userVM.getEmail());
        if (!pomocna.isEmpty())
            throw new EntityExistsException("Username or email already exists!");

        // provjeri dodavanje rola i passworda
        return userRepository.save(UserVM.toEntity(userVM)); // bcript

    }

    public User editUser(Integer id, UserVM userVM) {
        if (!userRepository.findByUserNameOrEmail(userVM.getUserName(), userVM.getEmail()).isEmpty())
            throw new EntityExistsException("Username or email already exists!");

        User user = userRepository.findById(id).orElseThrow(() -> new EntityExistsException("Could not find user with id " + id));

        user.setUserName(userVM.getUserName());
        user.setEmail(userVM.getEmail());
        user.setPassword(userVM.getPassword());
        user.setRoleId(userVM.getRoleId());

        // provjeri dodavanje rola i passworda
        return userRepository.save(user);

    }

    public User addRoleToUser(Integer id, Integer roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new EntityExistsException("Could not find role with id " + roleId));
        User user = userRepository.findById(id).orElseThrow(() -> new EntityExistsException("Could not find user with id " + id));
        user.setRole(role);
        return user;
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityExistsException("Could not find user with id " + id));
    }

    public Page<User> getAllUsers(int page, int size, String sortBy, String userName) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<User> users;
        if (userName != null) {
            users = userRepository.findByUserNameContaining(userName);
        } else {
            users = userRepository.findAll(pageable);
        }
        if (users.isEmpty()) {
            throw new EntityNotFoundException("There are no users");
        }
        return users;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
