package com.adore96.SpringAngularWebApp.controller;

import com.adore96.SpringAngularWebApp.bean.DataBean;
import com.adore96.SpringAngularWebApp.dao.StudentRepo;
import com.adore96.SpringAngularWebApp.model.Users;
import com.adore96.SpringAngularWebApp.securityConfig.BcryptFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "http://localhost:4200")
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    BcryptFunction bcryptFunction;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//    @RequestMapping("/login")
//    public String login() {
//        logger.info("Accessed Method : Login");
//        return "Login";
//    }

    @RequestMapping("/403")
    public String AccessDenied() {
        return "403";
    }

    @RequestMapping("/Newuser")
    public String newStudent() {
        return "Newuser";
    }

    @RequestMapping("/logout-success")
    public String logout() {
        return "Login";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @DeleteMapping("/DeleteStudent/{id}")
    public List<Users> DeleteStudent(@PathVariable String id) {
        System.out.println("DeleteStudent Method method in Main Controller.");

        int Id = Integer.valueOf(id);

        studentRepo.deleteById(Id);
        return studentRepo.findAll();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/EditStudent/{id}")
    public String EditStudent(@PathVariable String id, Model model) {
        System.out.println("EditStudent Method in Main Controller.");

        int Id = Integer.valueOf(id);

        Users user1 = new Users();
        user1 = studentRepo.getOne(Id);

        model.addAttribute("userdetails", user1);
        return "UserUpdate";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/")
    public String main(Model model) {

        List<Users> users = studentRepo.findAll();
        List<DataBean> dataBeans = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            DataBean dBean = new DataBean();
            dBean.setId(String.valueOf(users.get(i).getId()).trim());
            dBean.setFname(users.get(i).getFname().trim());
            dBean.setLname(users.get(i).getLname().trim());
            dBean.setUsername(users.get(i).getUsername().trim());
            dBean.setPassword(users.get(i).getPassword().trim());
            dBean.setTelephone(String.valueOf(users.get(i).getTelephone()).trim());

            dataBeans.add(dBean);
        }

        model.addAttribute("dataBean", dataBeans);
        return "Index";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RedirectView signup(@RequestBody DataBean dataBean) {
        System.out.println("Calling signup method in Main Controller.");
        BcryptFunction bcryptFunction = new BcryptFunction();

        Users users2 = new Users();

        users2.setFname(dataBean.getFname().trim());
        users2.setLname(dataBean.getLname().trim());
        users2.setUsername(dataBean.getUsername().trim());
        users2.setPassword(bcryptFunction.encoder().encode(dataBean.getPassword()).trim());
        users2.setTelephone(Integer.parseInt(dataBean.getTelephone().trim()));

        studentRepo.save(users2);

        return new RedirectView("/");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/EditStudent/updateStudent")
    public RedirectView updateStudent(DataBean dataBean) {

        Users users2 = new Users();

        users2.setFname(dataBean.getFname().trim());
        users2.setLname(dataBean.getLname().trim());
        users2.setUsername(dataBean.getUsername().trim());
        users2.setPassword(dataBean.getPassword().trim());
        users2.setTelephone(Integer.parseInt(dataBean.getTelephone().trim()));

        studentRepo.save(users2);

        return new RedirectView("/");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/findAllUsers")
    public List<Users> FindAllUsers() {
        return studentRepo.findAll();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/findById/{id}")
    public Optional<Users> findById(@PathVariable String id) {
        int newid = Integer.parseInt(id);
        return studentRepo.findById(newid);
    }
}
