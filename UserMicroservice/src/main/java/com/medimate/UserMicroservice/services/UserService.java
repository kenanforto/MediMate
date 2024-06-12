package com.medimate.UserMicroservice.services;

import com.medimate.UserMicroservice.models.Patient;
import com.medimate.UserMicroservice.models.Role;
import com.medimate.UserMicroservice.models.User;
import com.medimate.UserMicroservice.repositories.PatientRepository;
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
    private PatientRepository patientRepository;


    public User createUser(UserVM userVM) {
        User pomocna = userRepository.findByEmail(userVM.getEmail());
        if (pomocna!=null)
            throw new EntityExistsException("Email already exists!");

        // provjeri dodavanje rola i passworda
        User user= userRepository.save(UserVM.toEntity(userVM)); // bcript
        patientRepository.save(new Patient(null,null,null,null,user.getId()));
        return user;
    }

    public User editUser(Integer id, UserVM userVM) {
        if (userRepository.findByEmail(userVM.getEmail())!=null)
            throw new EntityExistsException("Email already exists!");

        User user = userRepository.findById(id).orElseThrow(() -> new EntityExistsException("Could not find user with id " + id));

        user.setEmail(userVM.getEmail());
        user.setPassword(userVM.getPassword());
        user.setRole(userVM.getRole());

        // provjeri dodavanje rola i passworda
        return userRepository.save(user);

    }

    public User addRoleToUser(Integer id, Role role) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityExistsException("Could not find user with id " + id));
        user.setRole(role);
        return user;
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityExistsException("Could not find user with id " + id));
    }
    public User getUserByEmail(String email) {
        try {
            return userRepository.findByEmail(email);
        }
        catch (Exception e)
        {
            throw  new EntityExistsException("Could not find user with email " + email);
        }
    }
    public Page<User> getAllUsers(int page, int size, String sortBy, String userName) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<User> users;

        users = userRepository.findAll(pageable);
        if (users.isEmpty()) {
            throw new EntityNotFoundException("There are no users");
        }
        return users;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
