package com.adore96.SampleWebApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String print(){
        System.out.println("home method called");
        return "HomePage";
    }
}
