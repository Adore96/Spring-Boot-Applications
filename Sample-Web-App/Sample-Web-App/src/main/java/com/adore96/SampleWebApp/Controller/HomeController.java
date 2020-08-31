package com.adore96.SampleWebApp.Controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String print(HttpServletRequest request){
        HttpSession httpSession = request.getSession();

        String name = request.getParameter("name");
        System.out.println("home method called");
        System.out.println("name  "+name);

        httpSession.setAttribute("name",name);

        return "HomePage";
    }
}
