package com.adore96.JwtApi.controller;

import com.adore96.JwtApi.bean.UserDatabean;
import com.adore96.JwtApi.entity.User;
import com.adore96.JwtApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/login")
    public String login() {
        return "Login";
    }

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

    @RequestMapping("/DeleteStudent/{id}")
    public RedirectView DeleteStudent(@PathVariable String id) {
        System.out.println("DeleteStudent Method method in Main Controller.");

        int Id = Integer.parseInt(id);

        userRepository.deleteById(Id);

        return new RedirectView("/");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/EditStudent/{id}")
    public String EditStudent(@PathVariable String id, Model model) {
        System.out.println("EditStudent Method in Main Controller.");

        int Id = Integer.parseInt(id);

        User user1 = userRepository.getOne(Id);

        model.addAttribute("userdetails", user1);
        return "UserUpdate";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/")
    public String main(Model model) {

        List<User> users = userRepository.findAll();
        List<UserDatabean> dataBeans = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            UserDatabean userDatabean = new UserDatabean();
            userDatabean.setId(String.valueOf(users.get(i).getId()).trim());
            userDatabean.setUsername(users.get(i).getUsername().trim());
            userDatabean.setPassword(users.get(i).getPassword().trim());
            userDatabean.setEmail(users.get(i).getEmail().trim());

            dataBeans.add(userDatabean);
        }

        model.addAttribute("dataBean", dataBeans);
        return "Index";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/signup")
    public RedirectView signup(UserDatabean userDatabean) {
        System.out.println("Calling signup method in Main Controller.");

//        BcryptFunction bcryptFunction = new BcryptFunction();

        User users2 = new User();

        users2.setUsername(userDatabean.getUsername().trim());
        users2.setEmail(userDatabean.getEmail().trim());
        users2.setPassword(userDatabean.getPassword().trim());
//        users2.setPassword(bcryptFunction.encoder().encode(dataBean.getPassword()).trim());

        userRepository.save(users2);
        return new RedirectView("/");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/updateStudent")
    public RedirectView updateStudent(UserDatabean userDatabean) {

        User users2 = new User();

        users2.setId(Integer.parseInt(userDatabean.getId().trim()));
        users2.setUsername(userDatabean.getUsername().trim());
        users2.setEmail(userDatabean.getEmail().trim());
        users2.setPassword(userDatabean.getPassword().trim());

        userRepository.save(users2);

        return new RedirectView("/");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("reguser")
    public String reguser(UserDatabean userDatabean) {
        System.out.println("Calling reguser method in Main Controller.");

//        BcryptFunction bcryptFunction = new BcryptFunction();

        User users2 = new User();

        users2.setUsername(userDatabean.getUsername().trim());
        users2.setEmail(userDatabean.getEmail().trim());
        users2.setPassword(userDatabean.getPassword().trim());
//        users2.setPassword(bcryptFunction.encoder().encode(dataBean.getPassword()).trim());

        userRepository.save(users2);
        return "Login";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @RequestMapping("/login?error")
    public void Error() {
        System.out.println("Error");
    }
}
