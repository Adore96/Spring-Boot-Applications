package com.adore96.SpringPOS.controller;

import com.adore96.SpringJWT.bean.UserDatabean;
import com.adore96.SpringJWT.model.User;
import com.adore96.SpringJWT.repository.UserRepo;
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

    @Autowired
    UserRepo userRepo;

    @PostMapping("/signup")
    public RedirectView signup(UserDatabean userDatabean) {
        System.out.println("Called Signup");
        userService.signUp(userDatabean);
        System.out.println("User " + userDatabean.getUsername() + " has been saved successfully.");
        return new RedirectView("/");
    }

    @RequestMapping("/editUser/{id}")
    public String EditStudent(@PathVariable String id, Model model) {
        System.out.println("editUser Method in UserController.");

        int Id = Integer.valueOf(id);

        User user = userRepo.getOne(Id);

        model.addAttribute("userdetails", user);
        return "userUpdate";
    }

//    @ResponseBody
//    public ResponseEntity<Boolean> saveData(HttpServletRequest request,
//                                            HttpServletResponse response, Model model){
//        String jsonString = request.getParameter("json");
//    }

    @PostMapping("/updateUser")
    public RedirectView updateStudent(UserDatabean userDatabean) {
        System.out.println("Calling updateUser method : " + userDatabean.getUsername());

        User user = new User();

        user.setFname(userDatabean.getFname().trim());
        user.setLname(userDatabean.getLname().trim());
        user.setUsername(userDatabean.getUsername().trim());
        user.setPassword(userDatabean.getPassword().trim());
        user.setTelephone(userDatabean.getTelephone());

//        Optional<Roledetails> roleid = roledetailsRepo.findByRoleid(userDatabean.getRoleid());
//        if (roleid.isPresent()) {
//            users2.setRoleid(roleid.get());
//        }

        userRepo.save(user);
        System.out.println("Data Updated Successfully.");
        return new RedirectView("/");
    }
}
