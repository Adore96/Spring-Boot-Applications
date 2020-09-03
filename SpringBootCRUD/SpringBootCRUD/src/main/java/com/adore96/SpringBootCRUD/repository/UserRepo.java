package com.adore96.SpringBootCRUD.repository;

import com.adore96.SpringBootCRUD.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Integer> {
}
