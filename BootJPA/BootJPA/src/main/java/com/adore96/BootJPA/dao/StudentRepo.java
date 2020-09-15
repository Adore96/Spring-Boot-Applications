package com.adore96.BootJPA.dao;

import com.adore96.BootJPA.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Users, Integer> {
//    List<Users> findByFname(String fname);

    //    List<Users> deleteByFname(String fname);
    Optional<Users> findByUsername(String username);

//    @Modifying
//    @Query("update Users u set u.fname = ?1, u.lname = ?2, u.username = ?2, u.password = ?2, u.telephone = ?2 where u.id = ?3")
//    void setUserInfoById(String fname, String lname, String username, String password, Integer telephone, Integer id);

}
