package com.adore96.BootJPA.dao;

import com.adore96.BootJPA.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface StudentRepo extends JpaRepository<Users,Integer> {
    List<Users> findByFname(String fname);
//    List<Users> deleteByFname(String fname);
    Users findByUsername(String username);

//    @Query(value = "SELECT FROM........WHERE....", nativeQuery = true)
//    List<Object[]> retrieveUserByFName();


}
