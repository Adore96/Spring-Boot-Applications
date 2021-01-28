package com.adore96.SpringJWT.controller;

import com.adore96.SpringJWT.bean.UserDatabean;
import com.adore96.SpringJWT.services.AuditService;
import com.adore96.SpringJWT.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author kasun_k ON 1/25/21
 * @project SpringJWT
 */

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuditService auditService;

    @PostMapping("/signup")
    public RedirectView signup(UserDatabean userDatabean) {
        System.out.println("Called Signup");
        userService.signUp(userDatabean);
        System.out.println("User " + userDatabean.getUsername() + " has been saved successfully.");
        return new RedirectView("/");
    }

    @RequestMapping("/EditStudent/{id}")
    public String EditStudent(@PathVariable String id, Model model) {
        System.out.println("EditStudent Method in Main Controller.");

        int Id = Integer.valueOf(id);

//        Users user1= new Users();
        Users user1 = studentRepo.getOne(Id);

        model.addAttribute("userdetails", user1);
        return "UserUpdate";
    }
}
