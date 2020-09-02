package com.adore96.BootJPA.dao;

import com.adore96.BootJPA.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepo extends CrudRepository<Student,Integer> {
    List<Student> findByFname(String fname);


}
