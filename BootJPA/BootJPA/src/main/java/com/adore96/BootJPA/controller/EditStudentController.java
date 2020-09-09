package com.adore96.BootJPA.controller;

import com.adore96.BootJPA.dao.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


public class EditStudentController {
    @Autowired
    StudentRepo studentRepo;

    @RequestMapping("/editStudent")
    public String main(){
        return null;
    }


}
