package com.adore96.SpringAngularWebApp.dao;

import com.adore96.SpringAngularWebApp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepo extends JpaRepository<Users, Integer> {

    Optional<Users> findByUsername(String username);

}