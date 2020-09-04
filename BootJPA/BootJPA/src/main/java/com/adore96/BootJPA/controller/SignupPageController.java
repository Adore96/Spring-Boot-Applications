package com.adore96.BootJPA.controller;

import com.adore96.BootJPA.bean.DataBean;
import com.adore96.BootJPA.dao.StudentRepo;
import com.adore96.BootJPA.model.Users;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SignupPageController {

    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/")
    public String home() {
//        System.out.println("Test --> "+studentRepo.getOne(1).getUsername());
        return "SignupPage.jsp";
    }

    @RequestMapping("/Signup")
    public String Signup(Users users) {
        studentRepo.save(users);
        System.out.println("Data Added Successfully.");
        return "SignupPage.jsp";
    }

    @RequestMapping("/Search")
    public ModelAndView Search(@RequestParam int id) {

        ModelAndView mv = new ModelAndView("ShowStudent.jsp");
        System.out.println("Test2 --> " + studentRepo.getOne(id).getUsername());
        Users users = studentRepo.findById(id).orElse(new Users());
        mv.addObject(users);
        return mv;
    }

    @RequestMapping("/fnameSearch")
    public ModelAndView fnameSearch(@RequestParam String fname) {
        ModelAndView mv = new ModelAndView("ShowfnameStudent.jsp");
        List<Users> users = studentRepo.findByFname(fname);
        System.out.println("----> " + users);
        return mv;
    }

//    @RequestMapping("/students")
//    @ResponseBody
//    public String GetAll() {
//        return studentRepo.findAll().toString();
//    }

    @RequestMapping("/Delete")
    public ModelAndView Delete(@RequestParam String fname) {
        System.out.println(fname);
        ModelAndView mv = new ModelAndView("ShowfnameStudent.jsp");
//        List<Users> users = studentRepo.findByFname(fname);
        studentRepo.deleteByFname(fname);
        return mv;
    }

    @RequestMapping("/users")
    public String getCustomers(Model model) {
//      ModelAndView mv = new ModelAndView("ShowStudent.jsp");
//        DataBean dataBean = new DataBean();
//        Users uclass = new Users();

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

//        BeanUtils.copyProperties(uclass, dataBean);
        model.addAttribute("dataBean", dataBeans);
        return "ShowStudent.jsp";
    }

}

