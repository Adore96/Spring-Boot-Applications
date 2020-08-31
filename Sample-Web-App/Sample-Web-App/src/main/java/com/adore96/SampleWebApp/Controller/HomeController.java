package com.adore96.SampleWebApp.Controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public ModelAndView print(@RequestParam("name")String name){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("name",name);

        modelAndView.setViewName("HomePage");

        return modelAndView ;
    }
}
