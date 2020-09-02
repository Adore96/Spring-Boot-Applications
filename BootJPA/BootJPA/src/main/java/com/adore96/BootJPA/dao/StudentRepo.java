package com.adore96.BootJPA.dao;

import com.adore96.BootJPA.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student,Integer> {

}
