package com.adore96.BootJPA.controller;

import com.adore96.BootJPA.dao.StudentRepo;
import com.adore96.BootJPA.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SignupPageController {

    @Autowired
    StudentRepo studentRepo;

//    @GetMapping("/")
//    public String home() {
////        System.out.println("Test --> "+studentRepo.getOne(1).getUsername());


    @RequestMapping("/signup")
    public String Signup(Users users) {

        studentRepo.save(users);
        System.out.println("Data Added Successfully.");
        return "SignupPage.jsp";
    }

    @RequestMapping("/search")
    public ModelAndView Search(@RequestParam int id) {

        ModelAndView mv = new ModelAndView("Dashboard.jsp");
        System.out.println("Test2 --> " + studentRepo.getOne(id).getUsername());
        Users users = studentRepo.findById(id).orElse(new Users());
        mv.addObject(users);
        return mv;
    }

    @RequestMapping("/searchbyfname")
    public ModelAndView fnameSearch(@RequestParam String fname) {

        ModelAndView mv = new ModelAndView("ShowfnameStudent.jsp");
        List<Users> users = studentRepo.findByFname(fname);
        System.out.println("----> " + users);
        return mv;
    }



}