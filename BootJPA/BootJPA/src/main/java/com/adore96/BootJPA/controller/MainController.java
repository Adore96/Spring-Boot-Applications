package com.adore96.BootJPA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/efes")
    public String main(){
        System.out.println("--------------");
        return "index";
    }
}
