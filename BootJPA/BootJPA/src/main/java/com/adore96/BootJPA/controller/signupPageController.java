package com.adore96.BootJPA.controller;

import com.adore96.BootJPA.dao.StudentRepo;
import com.adore96.BootJPA.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class signupPageController {

    @Autowired
    StudentRepo studentRepo;

    @RequestMapping("/")
    public String home() {
        return "signupPage.jsp";
    }

    @RequestMapping("/Signup")
    public String Signup(Student student) {
        studentRepo.save(student);
        System.out.println("Data Added Successfully.");
        return "signupPage.jsp";
    }

    @RequestMapping("/Search")
    public ModelAndView Search(@RequestParam int id) {

        ModelAndView mv = new ModelAndView("showStudent.jsp");
        Student student = studentRepo.findById(id).orElse(new Student());
        mv.addObject(student);
        return mv;
    }
}
