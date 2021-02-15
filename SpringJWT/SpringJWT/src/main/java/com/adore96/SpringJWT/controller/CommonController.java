package com.adore96.SpringJWT.controller;

import com.adore96.SpringJWT.bean.UserDatabean;
import com.adore96.SpringJWT.model.Audit;
import com.adore96.SpringJWT.model.User;
import com.adore96.SpringJWT.repository.UserRepo;
import com.adore96.SpringJWT.services.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kalharaperera ON 12/22/20
 * @project SpringJWT
 */

@Controller
public class CommonController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AuditService auditService;

    @RequestMapping("/")
    public String main(Model model) {
        System.out.println("-------");
        List<User> user = userRepo.findAll();
        List<UserDatabean> Databean = new ArrayList<>();

        for (int i = 0; i < user.size(); i++) {
            UserDatabean dBean = new UserDatabean();
            dBean.setUserId(String.valueOf(user.get(i).getUserId()).trim());
            dBean.setFname(user.get(i).getFname().trim());
            dBean.setLname(user.get(i).getLname().trim());
            dBean.setUsername(user.get(i).getUsername().trim());
            dBean.setRoleid(user.get(i).getRoleid());
            dBean.setTimeStamp(user.get(i).getTimeStamp());
            dBean.setTelephone(user.get(i).getTelephone());


//            Roledetails roledetails = user.get(i).getRoleid();
//            dBean.setRoleid(roledetails.getRolename());

            Databean.add(dBean);
        }

        model.addAttribute("Databean", Databean);
        return "Index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
