package com.adore96.SampleWebApp.Controller;

import com.adore96.SampleWebApp.Model.StudentInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public ModelAndView print(StudentInfo studentInfo){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("obj",studentInfo);

        modelAndView.setViewName("HomePage");

        return modelAndView ;
    }
}
