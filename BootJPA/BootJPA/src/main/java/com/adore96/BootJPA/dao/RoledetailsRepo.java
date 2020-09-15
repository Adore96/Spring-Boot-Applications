package com.adore96.BootJPA.dao;

import com.adore96.BootJPA.model.Roledetails;
import com.adore96.BootJPA.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoledetailsRepo extends JpaRepository<Roledetails, Integer> {
    Optional<Roledetails> findByRoleid(String roleid);
}
