package com.adore96.SpringJWT.repository;

import com.adore96.SpringJWT.model.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author kalharaperera ON 12/22/20
 * @project SpringJWT
 */

public interface userRepo extends JpaRepository<users, Integer> {
    
    Optional<users> findbyUsername(String username);
}
