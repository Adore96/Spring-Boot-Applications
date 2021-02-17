package com.adore96.SpringPOS.repository;

import com.adore96.SpringPOS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author kalharaperera ON 12/22/20
 * @project SpringPOS
 */

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
