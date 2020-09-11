package com.adore96.BootJPA.controller;

import com.adore96.BootJPA.bean.DataBean;
import com.adore96.BootJPA.dao.StudentRepo;
import com.adore96.BootJPA.model.Users;
import com.adore96.BootJPA.securityConfig.BcryptFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    StudentRepo studentRepo;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/login")
    public String login() {
        return "Login";
    }

    @RequestMapping("/logout-success")
    public String logout() {
        return "Login";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/DeleteStudent/{id}")
    public RedirectView DeleteStudent(@PathVariable String id) {
        System.out.println("DeleteStudent Method");

        System.out.println(id+"--------------------------------");
        int Id = Integer.valueOf(id);
        System.out.println(id+"===========================");

        studentRepo.deleteById(Id);

//        String redirectURL = "localhost:8090/";
        return new RedirectView("/");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/EditStudent/{id}")
    public String EditStudent(@PathVariable String id, Model model) {
        System.out.println("EditStudent Method");

        int Id = Integer.valueOf(id);
        System.out.println(Id+"===========================");

        Users user1 = new Users();
        user1 = studentRepo.getOne(Id);

        model.addAttribute("userdetails",user1);
        return "UserUpdate";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/")
    public String main(Model model) {

        List<Users> users = studentRepo.findAll();
        List<DataBean> dataBeans = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            DataBean dBean = new DataBean();
            dBean.setId(String.valueOf(users.get(i).getId()));
            dBean.setFname(users.get(i).getFname());
            dBean.setLname(users.get(i).getLname());
            dBean.setUsername(users.get(i).getUsername());
            dBean.setPassword(users.get(i).getPassword());
            dBean.setTelephone(String.valueOf(users.get(i).getTelephone()));

            dataBeans.add(dBean);
        }

        model.addAttribute("dataBean", dataBeans);
        return "Index";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/signup")
    public RedirectView signup(Users users) {
        System.out.println("Calling signup method.");

        BcryptFunction bcryptFunction = new BcryptFunction();

        Users users2 = new Users();

        System.out.println(users.getPassword()+"=====================");

        users2.setId(users.getId());
        users2.setFname(users.getFname());
        users2.setLname(users.getLname());
        users2.setUsername(users.getUsername());
        users2.setPassword(bcryptFunction.encoder().encode(users.getPassword()));
        users2.setTelephone(users.getTelephone());

        studentRepo.save(users2);
        System.out.println("Data Added Successfully.");
//        String redirectURL = "localhost:8090/";
        return new RedirectView("/");

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/EditStudent/updateStudent")
    public RedirectView updateStudent(Users users) {
        System.out.println("Calling updateStudent method.");
        studentRepo.save(users);
        System.out.println("Data Updated Successfully.");
        return new RedirectView("/");
    }

}

