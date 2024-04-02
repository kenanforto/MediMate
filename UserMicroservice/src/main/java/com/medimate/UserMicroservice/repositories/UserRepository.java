package com.medimate.UserMicroservice.repositories;

import com.medimate.UserMicroservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    @Query("SELECT u FROM User u WHERE u.userName ilike :userName AND u.email ilike :email")
//    List<User> findByUserNameOrEmail(@Param("userName") String userName, @Param("email") String email);
    List<User> findByUserNameOrEmail(String userName, String email);
    User findByUserName(String username);

}