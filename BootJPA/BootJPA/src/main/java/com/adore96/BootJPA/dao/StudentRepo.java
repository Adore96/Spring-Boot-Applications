package com.adore96.BootJPA.dao;

import com.adore96.BootJPA.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface StudentRepo extends JpaRepository<Users,Integer> {
    List<Users> findByFname(String fname);
    List<Users> deleteByFname(String fname);


}
