package com.adore96.BootJPA.controller;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/vghgv")
    public String main(){
        return "Dashboard.jsp";
    }
}
