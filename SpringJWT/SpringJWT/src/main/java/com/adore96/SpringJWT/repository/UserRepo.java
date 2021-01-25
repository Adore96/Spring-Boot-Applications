package com.adore96.SpringJWT.repository;

import com.adore96.SpringJWT.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kalharaperera ON 12/22/20
 * @project SpringJWT
 */

public interface UserRepo extends JpaRepository<User, Integer> {
//    Optional<User> findbyUsername(String username);
}
