package com.adore96.SpringJWT.controller;

import com.adore96.SpringJWT.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kalharaperera ON 12/22/20
 * @project SpringJWT
 */

@Controller
public class CommonController {

    @RequestMapping("/")
    public String logout() {
        return "index";
    }
}
