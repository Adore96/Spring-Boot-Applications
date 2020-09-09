package com.adore96.BootJPA.controller;

import com.adore96.BootJPA.dao.StudentRepo;
import com.adore96.BootJPA.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


public class DeleteStudentController{

    @Autowired
    StudentRepo studentRepo;
    UserlistController userlistController;

    @RequestMapping("/DeleteStudent")
    public String Delete(@RequestParam String id) {


        int Id = Integer.valueOf(id);
        System.out.println(id);
        Optional<Users> users = studentRepo.findById(Id);

        studentRepo.deleteById(Id);
        String redirectURL = "localhost:8090/userlist";
        return "redirect:" + redirectURL;
    }
}
